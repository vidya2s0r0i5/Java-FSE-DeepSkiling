CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);
CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
); 

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified) VALUES (7, 'Nina Patel', TO_DATE('1955-09-30', 'YYYY-MM-DD'), 9500, SYSDATE);
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified) VALUES (6, 'David Wright', TO_DATE('1988-11-11', 'YYYY-MM-DD'), 20000, SYSDATE);
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified) VALUES (5, 'Sara Khan', TO_DATE('2000-01-05', 'YYYY-MM-DD'), 500, SYSDATE);
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified) VALUES (4, 'Michael Lee', TO_DATE('1962-08-25', 'YYYY-MM-DD'), 8000, SYSDATE);
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified) VALUES (3, 'Emily Clark', TO_DATE('1970-03-10', 'YYYY-MM-DD'), 12000, SYSDATE);


INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified) VALUES (3, 3, 'Savings', 12000, SYSDATE);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified) VALUES (4, 4, 'Checking', 8000, SYSDATE);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified) VALUES (5, 5, 'Savings', 500, SYSDATE);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified) VALUES (6, 6, 'Savings', 20000, SYSDATE);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified) VALUES (7, 7, 'Checking', 9500, SYSDATE);

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType) VALUES (3, 3, SYSDATE, 1000, 'Deposit');
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType) VALUES (4, 4, SYSDATE, 500, 'Withdrawal');
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType) VALUES (5, 5, SYSDATE, 200, 'Deposit');
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType) VALUES (6, 6, SYSDATE, 3000, 'Deposit');
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType) VALUES (7, 7, SYSDATE, 1500, 'Withdrawal');

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate) VALUES (2, 5, 7000, 4.5, SYSDATE, ADD_MONTHS(SYSDATE, 48));
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate) VALUES (3, 3, 15000, 5.2, SYSDATE, ADD_MONTHS(SYSDATE, 60));
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate) VALUES (6, 6, 20000, 3.9, SYSDATE, ADD_MONTHS(SYSDATE, 72));
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate) VALUES (4, 4, 9000, 4.0, SYSDATE, ADD_MONTHS(SYSDATE, 36));
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate) VALUES (5, 7, 2500, 6.5, SYSDATE, ADD_MONTHS(SYSDATE, 24));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate) VALUES (3, 'Clara Benson', 'Analyst', 50000, 'Finance', TO_DATE('2018-10-01', 'YYYY-MM-DD'));
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate) VALUES (5, 'Anita Roy', 'Developer', 62000, 'IT', TO_DATE('2019-07-10', 'YYYY-MM-DD'));
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate) VALUES (4, 'George Hill', 'Clerk', 35000, 'Operations', TO_DATE('2020-02-15', 'YYYY-MM-DD'));
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate) VALUES (6, 'Daniel Park', 'Manager', 75000, 'Sales', TO_DATE('2014-05-12', 'YYYY-MM-DD'));
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate) VALUES (7, 'Leena Gomes', 'HR Executive', 48000, 'HR', TO_DATE('2016-12-20', 'YYYY-MM-DD'));