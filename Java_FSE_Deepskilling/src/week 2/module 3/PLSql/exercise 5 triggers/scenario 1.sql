CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
   :NEW.LastModified := SYSDATE;
END;

--to modify
UPDATE Customers
SET Balance = Balance + 1000
WHERE CustomerID = 6;

COMMIT;

--to check
SELECT CustomerID, Name, LastModified FROM Customers WHERE CustomerID = 6;