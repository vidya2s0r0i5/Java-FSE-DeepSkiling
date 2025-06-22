package module1.design_Patterns_and_Principles.ObserverPattern;

public class Tester {
	public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobile1 = new MobileApp("OnePlus");
        Observer web1 = new WebApp("NSE Portal");

        stockMarket.registerObserver(mobile1);
        stockMarket.registerObserver(web1);

        System.out.println("--- First Update ---");
        stockMarket.setStockPrice(1250.75);
        System.out.println();

        System.out.println("--- Second Update ---");
        stockMarket.setStockPrice(1299.99);

        // Unregister mobile app
        stockMarket.removeObserver(mobile1);

        System.out.println();
        System.out.println("--- Third Update (after mobile unregistered) ---");
        stockMarket.setStockPrice(1305.25);
    }

}
