CREATE TABLE AuditLog (
   LogID            NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
   TransactionID    NUMBER,
   AccountID        NUMBER,
   Amount           NUMBER,
   TransactionType  VARCHAR2(10),
   TransactionDate  DATE,
   LoggedAt         DATE
);

--procedure
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
   INSERT INTO AuditLog (
      TransactionID,
      AccountID,
      Amount,
      TransactionType,
      TransactionDate,
      LoggedAt
   )
   VALUES (
      :NEW.TransactionID,
      :NEW.AccountID,
      :NEW.Amount,
      :NEW.TransactionType,
      :NEW.TransactionDate,
      SYSDATE
   );
END;


INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (100, 3, SYSDATE, 1500, 'Deposit');

COMMIT;

SELECT * FROM AuditLog WHERE TransactionID = 100;