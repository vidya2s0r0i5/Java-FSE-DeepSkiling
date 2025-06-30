CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

   PROCEDURE AddCustomer (
      p_customer_id IN NUMBER,
      p_name        IN VARCHAR2,
      p_dob         IN DATE,
      p_balance     IN NUMBER
   ) IS
   BEGIN
      INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
      VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);

      COMMIT;
      DBMS_OUTPUT.PUT_LINE('Customer added successfully. ID: ' || p_customer_id);
   EXCEPTION
      WHEN DUP_VAL_ON_INDEX THEN
         DBMS_OUTPUT.PUT_LINE('Error: Customer with ID ' || p_customer_id || ' already exists.');
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
   END;

   PROCEDURE UpdateCustomerDetails (
      p_customer_id IN NUMBER,
      p_name        IN VARCHAR2,
      p_dob         IN DATE
   ) IS
   BEGIN
      UPDATE Customers
      SET Name = p_name,
          DOB = p_dob,
          LastModified = SYSDATE
      WHERE CustomerID = p_customer_id;

      IF SQL%ROWCOUNT = 0 THEN
         DBMS_OUTPUT.PUT_LINE('Customer ID ' || p_customer_id || ' not found.');
      ELSE
         COMMIT;
         DBMS_OUTPUT.PUT_LINE('Customer details updated for ID: ' || p_customer_id);
      END IF;
   END;

   FUNCTION GetCustomerBalance (
      p_customer_id IN NUMBER
   ) RETURN NUMBER IS
      v_balance NUMBER;
   BEGIN
      SELECT Balance INTO v_balance
      FROM Customers
      WHERE CustomerID = p_customer_id;

      RETURN v_balance;
   EXCEPTION
      WHEN NO_DATA_FOUND THEN
         DBMS_OUTPUT.PUT_LINE('Customer not found.');
         RETURN NULL;
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
         RETURN NULL;
   END;

END CustomerManagement;