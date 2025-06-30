CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
   p_loan_amount     IN NUMBER,
   p_annual_rate     IN NUMBER,
   p_years           IN NUMBER
) RETURN NUMBER IS
   v_monthly_rate    NUMBER;
   v_months          NUMBER;
   v_emi             NUMBER;
BEGIN
   -- Convert annual rate to monthly decimal rate
   v_monthly_rate := p_annual_rate / 12 / 100;
   v_months := p_years * 12;

   -- EMI formula: P * r * (1 + r)^n / ((1 + r)^n - 1)
   IF v_monthly_rate = 0 THEN
      v_emi := p_loan_amount / v_months;  -- No interest case
   ELSE
      v_emi := p_loan_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_months)
               / (POWER(1 + v_monthly_rate, v_months) - 1);
   END IF;

   RETURN ROUND(v_emi, 2);
END;


--to use fuction in schema
SELECT LoanID,
       LoanAmount,
       InterestRate,
       CalculateMonthlyInstallment(LoanAmount, InterestRate, 5) AS MonthlyEMI
FROM Loans;