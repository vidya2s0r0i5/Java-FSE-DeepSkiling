CREATE OR REPLACE FUNCTION CalculateAge (
   p_dob IN DATE
) RETURN NUMBER IS
   v_age NUMBER;
BEGIN
   -- Calculate age in years
   v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
   RETURN v_age;
END;


--to use function
SELECT Name, DOB, CalculateAge(DOB) AS Age
FROM Customers;