CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
   -- Update balance for all 'Savings' accounts by adding 1% interest
   UPDATE Accounts
   SET Balance = Balance + (Balance * 0.01),
       LastModified = SYSDATE
   WHERE AccountType = 'Savings';

   COMMIT;
   DBMS_OUTPUT.PUT_LINE('Monthly interest of 1% applied to all savings accounts.');
EXCEPTION
   WHEN OTHERS THEN
      ROLLBACK;
      DBMS_OUTPUT.PUT_LINE('Error applying interest: ' || SQLERRM);
END;

EXEC ProcessMonthlyInterest;

--to see whether it has been applied
SELECT AccountID, Balance FROM Accounts WHERE AccountType = 'Savings';