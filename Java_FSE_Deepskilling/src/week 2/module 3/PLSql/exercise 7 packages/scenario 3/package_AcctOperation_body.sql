CREATE OR REPLACE PACKAGE BODY AccountOperations AS

   PROCEDURE OpenAccount (
      p_account_id   IN NUMBER,
      p_customer_id  IN NUMBER,
      p_account_type IN VARCHAR2,
      p_balance      IN NUMBER
   ) IS
   BEGIN
      INSERT INTO Accounts (
         AccountID, CustomerID, AccountType, Balance, LastModified
      ) VALUES (
         p_account_id, p_customer_id, p_account_type, p_balance, SYSDATE
      );

      COMMIT;
      DBMS_OUTPUT.PUT_LINE('Account opened successfully: ' || p_account_id);
   EXCEPTION
      WHEN DUP_VAL_ON_INDEX THEN
         DBMS_OUTPUT.PUT_LINE('Error: Account ID ' || p_account_id || ' already exists.');
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
   END;

   PROCEDURE CloseAccount (
      p_account_id IN NUMBER
   ) IS
   BEGIN
      DELETE FROM Accounts
      WHERE AccountID = p_account_id;

      IF SQL%ROWCOUNT = 0 THEN
         DBMS_OUTPUT.PUT_LINE('Account ID ' || p_account_id || ' not found.');
      ELSE
         COMMIT;
         DBMS_OUTPUT.PUT_LINE('Account ID ' || p_account_id || ' closed.');
      END IF;
   END;

   FUNCTION GetTotalBalance (
      p_customer_id IN NUMBER
   ) RETURN NUMBER IS
      v_total NUMBER := 0;
   BEGIN
      SELECT NVL(SUM(Balance), 0)
      INTO v_total
      FROM Accounts
      WHERE CustomerID = p_customer_id;

      RETURN v_total;
   EXCEPTION
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
         RETURN NULL;
   END;

END AccountOperations;