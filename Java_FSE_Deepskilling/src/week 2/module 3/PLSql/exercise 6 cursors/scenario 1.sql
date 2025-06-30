DECLARE
   CURSOR txn_cursor IS
      SELECT c.CustomerID, c.Name, a.AccountID, t.TransactionDate, 
             t.TransactionType, t.Amount
      FROM Customers c
      JOIN Accounts a ON c.CustomerID = a.CustomerID
      JOIN Transactions t ON a.AccountID = t.AccountID
      WHERE TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM')  -- Current month
      ORDER BY c.CustomerID, t.TransactionDate;

   v_cust_id        Customers.CustomerID%TYPE;
   v_name           Customers.Name%TYPE;
   v_acc_id         Accounts.AccountID%TYPE;
   v_txn_date       Transactions.TransactionDate%TYPE;
   v_txn_type       Transactions.TransactionType%TYPE;
   v_amount         Transactions.Amount%TYPE;
   v_last_id        NUMBER := -1;

BEGIN
   DBMS_OUTPUT.PUT_LINE('--- Monthly Statements ---');

   OPEN txn_cursor;
   LOOP
      FETCH txn_cursor INTO v_cust_id, v_name, v_acc_id, v_txn_date, v_txn_type, v_amount;
      EXIT WHEN txn_cursor%NOTFOUND;

      IF v_cust_id != v_last_id THEN
         DBMS_OUTPUT.PUT_LINE(CHR(10) || 'Customer: ' || v_name || ' (ID: ' || v_cust_id || ')');
         DBMS_OUTPUT.PUT_LINE('--------------------------------------');
         v_last_id := v_cust_id;
      END IF;

      DBMS_OUTPUT.PUT_LINE('Account ID: ' || v_acc_id || 
                           ', Date: ' || TO_CHAR(v_txn_date, 'DD-MON-YYYY') || 
                           ', Type: ' || v_txn_type || 
                           ', Amount: ₹' || TO_CHAR(v_amount, '99999.99'));
   END LOOP;
   CLOSE txn_cursor;
END;
--to check OUTPUT
SELECT * FROM Transactions
WHERE TRUNC(TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM');