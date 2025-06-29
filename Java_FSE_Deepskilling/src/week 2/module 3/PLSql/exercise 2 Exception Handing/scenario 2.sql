CREATE OR REPLACE PROCEDURE UpdateSalary (
   p_employee_id IN NUMBER,
   p_percentage   IN NUMBER
) AS
   v_count NUMBER;
BEGIN
   -- Check if the employee exists
   SELECT COUNT(*) INTO v_count
   FROM Employees
   WHERE EmployeeID = p_employee_id;

   IF v_count = 0 THEN
      DBMS_OUTPUT.PUT_LINE('Error: Employee with ID ' || p_employee_id || ' does not exist.');
      RETURN;
   END IF;

   -- Update salary
   UPDATE Employees
   SET Salary = Salary + (Salary * p_percentage / 100)
   WHERE EmployeeID = p_employee_id;

   COMMIT;
   DBMS_OUTPUT.PUT_LINE('Salary updated successfully for Employee ID ' || p_employee_id);
EXCEPTION
   WHEN OTHERS THEN
      ROLLBACK;
      DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;

EXEC UpdateSalary(99, 10);