SELECT * FROM Loans;

BEGIN
   FOR cust IN (
      SELECT c.CustomerID
      FROM Customers c
      WHERE MONTHS_BETWEEN(SYSDATE, c.DOB)/12 > 60
   ) LOOP
      UPDATE Loans
      SET InterestRate = InterestRate - 1
      WHERE CustomerID = cust.CustomerID;
   END LOOP;
   COMMIT;
END;

SELECT * FROM Loans WHERE CustomerID IN (
   SELECT CustomerID FROM Customers WHERE MONTHS_BETWEEN(SYSDATE, DOB)/12 > 60
);