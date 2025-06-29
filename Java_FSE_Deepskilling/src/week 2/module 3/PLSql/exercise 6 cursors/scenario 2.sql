SET SERVEROUTPUT ON;

DECLARE
   CURSOR acc_cursor IS
      SELECT AccountID, Balance
      FROM Accounts;

   v_acc_id   Accounts.AccountID%TYPE;
   v_balance  Accounts.Balance%TYPE;

   v_fee      CONSTANT NUMBER := 250;  -- Set annual maintenance fee
BEGIN
   DBMS_OUTPUT.PUT_LINE('--- Applying Annual Maintenance Fee ---');

   OPEN acc_cursor;
   LOOP
      FETCH acc_cursor INTO v_acc_id, v_balance;
      EXIT WHEN acc_cursor%NOTFOUND;

      -- Check if balance is sufficient before deducting
      IF v_balance >= v_fee THEN
         UPDATE Accounts
         SET Balance = Balance - v_fee,
             LastModified = SYSDATE
         WHERE AccountID = v_acc_id;

         DBMS_OUTPUT.PUT_LINE('Fee of ₹' || v_fee || ' applied to Account ID: ' || v_acc_id);
      ELSE
         DBMS_OUTPUT.PUT_LINE('Skipped Account ID ' || v_acc_id || ' (Insufficient balance)');
      END IF;
   END LOOP;
   CLOSE acc_cursor;

   COMMIT;
   DBMS_OUTPUT.PUT_LINE('Annual fee processing complete.');
END;