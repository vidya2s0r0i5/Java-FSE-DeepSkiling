CREATE OR REPLACE FUNCTION HasSufficientBalance (
   p_account_id IN NUMBER,
   p_amount     IN NUMBER
) RETURN BOOLEAN IS
   v_balance NUMBER;
BEGIN
   SELECT Balance INTO v_balance
   FROM Accounts
   WHERE AccountID = p_account_id;

   RETURN v_balance >= p_amount;
EXCEPTION
   WHEN NO_DATA_FOUND THEN
      DBMS_OUTPUT.PUT_LINE('Account ID not found: ' || p_account_id);
      RETURN FALSE;
   WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
      RETURN FALSE;
END;


--using function
DECLARE
   v_result BOOLEAN;
BEGIN
   v_result := HasSufficientBalance(3, 500);

   IF v_result THEN
      DBMS_OUTPUT.PUT_LINE('Sufficient balance available.');
   ELSE
      DBMS_OUTPUT.PUT_LINE('Insufficient balance or account not found.');
   END IF;
END;