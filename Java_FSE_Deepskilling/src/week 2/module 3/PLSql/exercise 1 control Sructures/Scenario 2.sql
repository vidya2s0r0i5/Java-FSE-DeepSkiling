ALTER TABLE Customers ADD IsVIP VARCHAR2(5);

-- Before
SELECT CustomerID, Name, Balance, IsVIP FROM Customers;

BEGIN
   FOR cust IN (
      SELECT CustomerID, Balance FROM Customers
   ) LOOP
      IF cust.Balance > 10000 THEN
         UPDATE Customers
         SET IsVIP = 'TRUE'
         WHERE CustomerID = cust.CustomerID;
      END IF;
   END LOOP;
   COMMIT;
END;

SELECT CustomerID, Name, Balance, IsVIP FROM Customers
WHERE Balance > 10000;