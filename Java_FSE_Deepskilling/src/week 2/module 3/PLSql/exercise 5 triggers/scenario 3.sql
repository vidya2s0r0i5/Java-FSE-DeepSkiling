CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
   v_balance NUMBER;
BEGIN
   -- Get the current balance of the account
   SELECT Balance INTO v_balance
   FROM Accounts
   WHERE AccountID = :NEW.AccountID;

   -- Rule: Deposit must be positive
   IF :NEW.TransactionType = 'Deposit' THEN
      IF :NEW.Amount <= 0 THEN
         RAISE_APPLICATION_ERROR(-20001, 'Deposit amount must be positive.');
      END IF;

   -- Rule: Withdrawal must not exceed balance
   ELSIF :NEW.TransactionType = 'Withdrawal' THEN
      IF :NEW.Amount <= 0 THEN
         RAISE_APPLICATION_ERROR(-20002, 'Withdrawal amount must be positive.');
      ELSIF :NEW.Amount > v_balance THEN
         RAISE_APPLICATION_ERROR(-20003, 'Insufficient balance for withdrawal.');
      END IF;
   END IF;
END;

---to check
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (102, 3, SYSDATE, -500, 'Deposit');