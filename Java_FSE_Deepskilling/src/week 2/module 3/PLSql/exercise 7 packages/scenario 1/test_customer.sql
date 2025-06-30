--to add customer
BEGIN
   CustomerManagement.AddCustomer(12, 'Ravi Verma', TO_DATE('1990-05-10', 'YYYY-MM-DD'), 7000);
END;
--to update customer
BEGIN
   CustomerManagement.UpdateCustomerDetails(12, 'R. Verma', TO_DATE('1990-05-10', 'YYYY-MM-DD'));
END;
--to get balance

DECLARE
   v_balance NUMBER;
BEGIN
   v_balance := CustomerManagement.GetCustomerBalance(12);
   DBMS_OUTPUT.PUT_LINE('Balance: ₹' || v_balance);
END;