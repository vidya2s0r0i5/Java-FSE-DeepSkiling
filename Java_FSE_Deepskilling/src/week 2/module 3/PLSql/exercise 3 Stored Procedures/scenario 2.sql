CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
   p_department     IN VARCHAR2,
   p_bonus_percent  IN NUMBER
) AS
BEGIN
   -- Update salaries for employees in the specified department
   UPDATE Employees
   SET Salary = Salary + (Salary * p_bonus_percent / 100)
   WHERE Department = p_department;

   IF SQL%ROWCOUNT = 0 THEN
      DBMS_OUTPUT.PUT_LINE('No employees found in department: ' || p_department);
   ELSE
      DBMS_OUTPUT.PUT_LINE('Bonus of ' || p_bonus_percent || '% applied to department: ' || p_department);
   END IF;

   COMMIT;
EXCEPTION
   WHEN OTHERS THEN
      ROLLBACK;
      DBMS_OUTPUT.PUT_LINE('Error applying bonus: ' || SQLERRM);
END;

EXEC UpdateEmployeeBonus('IT', 10);

--After applyng bonus
SELECT EmployeeID, Name, Department, Salary FROM Employees WHERE Department = 'IT';