CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

   PROCEDURE HireEmployee (
      p_emp_id     IN NUMBER,
      p_name       IN VARCHAR2,
      p_position   IN VARCHAR2,
      p_salary     IN NUMBER,
      p_department IN VARCHAR2,
      p_hire_date  IN DATE
   ) IS
   BEGIN
      INSERT INTO Employees (
         EmployeeID, Name, Position, Salary, Department, HireDate
      ) VALUES (
         p_emp_id, p_name, p_position, p_salary, p_department, p_hire_date
      );

      COMMIT;
      DBMS_OUTPUT.PUT_LINE('Hired employee: ' || p_name);
   EXCEPTION
      WHEN DUP_VAL_ON_INDEX THEN
         DBMS_OUTPUT.PUT_LINE('Error: Employee with ID ' || p_emp_id || ' already exists.');
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
   END;

   PROCEDURE UpdateEmployeeDetails (
      p_emp_id     IN NUMBER,
      p_name       IN VARCHAR2,
      p_position   IN VARCHAR2,
      p_salary     IN NUMBER,
      p_department IN VARCHAR2
   ) IS
   BEGIN
      UPDATE Employees
      SET Name = p_name,
          Position = p_position,
          Salary = p_salary,
          Department = p_department
      WHERE EmployeeID = p_emp_id;

      IF SQL%ROWCOUNT = 0 THEN
         DBMS_OUTPUT.PUT_LINE('Employee ID ' || p_emp_id || ' not found.');
      ELSE
         COMMIT;
         DBMS_OUTPUT.PUT_LINE('Employee details updated for ID: ' || p_emp_id);
      END IF;
   END;

   FUNCTION GetAnnualSalary (
      p_emp_id IN NUMBER
   ) RETURN NUMBER IS
      v_salary Employees.Salary%TYPE;
   BEGIN
      SELECT Salary INTO v_salary
      FROM Employees
      WHERE EmployeeID = p_emp_id;

      RETURN v_salary * 12;
   EXCEPTION
      WHEN NO_DATA_FOUND THEN
         DBMS_OUTPUT.PUT_LINE('Employee not found.');
         RETURN NULL;
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
         RETURN NULL;
   END;

END EmployeeManagement;