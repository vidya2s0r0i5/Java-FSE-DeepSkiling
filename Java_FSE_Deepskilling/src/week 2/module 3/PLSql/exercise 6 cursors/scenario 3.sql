DECLARE
   CURSOR loan_cursor IS
      SELECT LoanID, LoanAmount, InterestRate
      FROM Loans;

   v_loan_id     Loans.LoanID%TYPE;
   v_amount      Loans.LoanAmount%TYPE;
   v_old_rate    Loans.InterestRate%TYPE;
   v_new_rate    NUMBER;
BEGIN
   DBMS_OUTPUT.PUT_LINE('--- Updating Loan Interest Rates Based on New Policy ---');

   OPEN loan_cursor;
   LOOP
      FETCH loan_cursor INTO v_loan_id, v_amount, v_old_rate;
      EXIT WHEN loan_cursor%NOTFOUND;

      -- Apply new interest rate policy
      IF v_amount < 10000 THEN
         v_new_rate := 6;
      ELSIF v_amount BETWEEN 10000 AND 50000 THEN
         v_new_rate := 5;
      ELSE
         v_new_rate := 4.5;
      END IF;

      -- Update only if rate has changed
      IF v_new_rate != v_old_rate THEN
         UPDATE Loans
         SET InterestRate = v_new_rate
         WHERE LoanID = v_loan_id;

         DBMS_OUTPUT.PUT_LINE('Loan ID: ' || v_loan_id || 
                              ' | Old Rate: ' || v_old_rate || '%' ||
                              ' → New Rate: ' || v_new_rate || '%');
      END IF;
   END LOOP;
   CLOSE loan_cursor;

   COMMIT;
   DBMS_OUTPUT.PUT_LINE('Interest rate update complete.');
END;


--test procdure and display updated loan
SELECT LoanID, LoanAmount, InterestRate FROM Loans;