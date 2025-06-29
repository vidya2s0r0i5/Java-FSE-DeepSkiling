CREATE OR REPLACE PACKAGE EmployeeManagement AS
   -- Procedure to hire a new employee
   PROCEDURE HireEmployee(
      p_emp_id     IN NUMBER,
      p_name       IN VARCHAR2,
      p_position   IN VARCHAR2,
      p_salary     IN NUMBER,
      p_department IN VARCHAR2,
      p_hire_date  IN DATE
   );

   -- Procedure to update existing employee details
   PROCEDURE UpdateEmployeeDetails(
      p_emp_id     IN NUMBER,
      p_name       IN VARCHAR2,
      p_position   IN VARCHAR2,
      p_salary     IN NUMBER,
      p_department IN VARCHAR2
   );

   -- Function to calculate annual salary
   FUNCTION GetAnnualSalary(
      p_emp_id IN NUMBER
   ) RETURN NUMBER;
END EmployeeManagement;