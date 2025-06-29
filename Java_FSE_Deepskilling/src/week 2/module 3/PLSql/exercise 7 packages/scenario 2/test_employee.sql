--to hire an employee
BEGIN
   EmployeeManagement.HireEmployee(
      101, 'Neha Sharma', 'Analyst', 45000, 'Finance', TO_DATE('2022-08-01', 'YYYY-MM-DD')
   );
END;
--to update employee
BEGIN
   EmployeeManagement.UpdateEmployeeDetails(
      101, 'Neha S.', 'Senior Analyst', 50000, 'Finance'
   );
END;

--to get salary
DECLARE
   v_annual_salary NUMBER;
BEGIN
   v_annual_salary := EmployeeManagement.GetAnnualSalary(101);
   DBMS_OUTPUT.PUT_LINE('Annual Salary: ₹' || v_annual_salary);
END;