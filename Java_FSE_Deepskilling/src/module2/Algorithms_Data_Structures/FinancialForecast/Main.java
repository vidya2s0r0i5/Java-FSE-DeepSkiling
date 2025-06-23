package module2.Algorithms_Data_Structures.FinancialForecast;

public class Main {
    public static void main(String[] args) {
        Forecast service = new Forecast();

        double initial = 10000.0;
        double growthRate = 0.10; // 10% annual growth
        int years = 5;

        double result = service.forecastValue(initial, growthRate, years);
        System.out.printf("Recursive Forecast (%.0f%% for %d years): ₹%.2f\n", growthRate * 100, years, result);

        double tailResult = service.forecastValueTail(initial, growthRate, years);
        System.out.printf("Tail Recursion Forecast: ₹%.2f\n", tailResult);
    }
}
