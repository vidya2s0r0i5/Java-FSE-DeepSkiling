--to open account
BEGIN
   AccountOperations.OpenAccount(10, 4, 'Savings', 3000);
END;

--to close account
BEGIN
   AccountOperations.CloseAccount(10);
END;
--to get balance

DECLARE
   v_balance NUMBER;
BEGIN
   v_balance := AccountOperations.GetTotalBalance(3);
   DBMS_OUTPUT.PUT_LINE('Total Balance for Customer 3: ₹' || v_balance);
END;