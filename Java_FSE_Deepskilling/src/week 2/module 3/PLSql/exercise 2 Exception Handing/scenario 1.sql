CREATE OR REPLACE PROCEDURE SafeTransferFunds (
   p_from_account_id IN NUMBER,
   p_to_account_id IN NUMBER,
   p_amount IN NUMBER
) AS
   v_balance NUMBER;
BEGIN
   -- Check balance of sender
   SELECT Balance INTO v_balance
   FROM Accounts
   WHERE AccountID = p_from_account_id;
   IF v_balance < p_amount THEN
      RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
   END IF;
   -- Deduct from sender
   UPDATE Accounts
   SET Balance = Balance - p_amount,
       LastModified = SYSDATE
   WHERE AccountID = p_from_account_id;
   -- Credit to receiver
   UPDATE Accounts
   SET Balance = Balance + p_amount,
       LastModified = SYSDATE
   WHERE AccountID = p_to_account_id;
   COMMIT;
   DBMS_OUTPUT.PUT_LINE('Transfer completed successfully.');
EXCEPTION
   WHEN OTHERS THEN
      ROLLBACK;
      DBMS_OUTPUT.PUT_LINE('Error during fund transfer: ' || SQLERRM);
END;