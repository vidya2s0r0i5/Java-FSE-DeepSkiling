CREATE OR REPLACE PROCEDURE TransferFunds (
   p_from_account_id IN NUMBER,
   p_to_account_id   IN NUMBER,
   p_amount          IN NUMBER
) AS
   v_from_balance NUMBER;
   v_from_customer_id NUMBER;
   v_to_customer_id   NUMBER;
BEGIN
   -- Get source account balance and customer
   SELECT Balance, CustomerID INTO v_from_balance, v_from_customer_id
   FROM Accounts
   WHERE AccountID = p_from_account_id;

   -- Get destination account's customer
   SELECT CustomerID INTO v_to_customer_id
   FROM Accounts
   WHERE AccountID = p_to_account_id;

   -- Check if both accounts belong to the same customer
   IF v_from_customer_id != v_to_customer_id THEN
      DBMS_OUTPUT.PUT_LINE('Error: Cannot transfer between accounts of different customers.');
      RETURN;
   END IF;

   -- Check for sufficient funds
   IF v_from_balance < p_amount THEN
      DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in source account.');
      RETURN;
   END IF;

   -- Perform transfer
   UPDATE Accounts
   SET Balance = Balance - p_amount,
       LastModified = SYSDATE
   WHERE AccountID = p_from_account_id;

   UPDATE Accounts
   SET Balance = Balance + p_amount,
       LastModified = SYSDATE
   WHERE AccountID = p_to_account_id;

   COMMIT;
   DBMS_OUTPUT.PUT_LINE('Transfer of ' || p_amount || ' successful between accounts ' ||
                        p_from_account_id || ' and ' || p_to_account_id);
EXCEPTION
   WHEN NO_DATA_FOUND THEN
      DBMS_OUTPUT.PUT_LINE('Error: One or both account IDs not found.');
   WHEN OTHERS THEN
      ROLLBACK;
      DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;

EXEC TransferFunds(3, 5, 500);  -- Assuming both accounts belong to CustomerID = 3