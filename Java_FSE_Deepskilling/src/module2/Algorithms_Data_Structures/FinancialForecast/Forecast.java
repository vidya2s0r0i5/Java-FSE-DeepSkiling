package module2.Algorithms_Data_Structures.FinancialForecast;

public class Forecast {

    // Recursive function to calculate future value
    public double forecastValue(double initialValue, double growthRate, int n) {
        if (n == 0) return initialValue;
        return forecastValue(initialValue, growthRate, n - 1) * (1 + growthRate);
    }

    // Optimized: Tail recursion using helper (optional)
    public double forecastValueTail(double initialValue, double growthRate, int n) {
        return forecastHelper(initialValue, growthRate, n);
    }

    private double forecastHelper(double value, double rate, int n) {
        if (n == 0) return value;
        return forecastHelper(value * (1 + rate), rate, n - 1);
    }
}

