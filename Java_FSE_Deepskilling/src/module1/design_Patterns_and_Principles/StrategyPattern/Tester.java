package module1.design_Patterns_and_Principles.StrategyPattern;

public class Tester {
	
	public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Use Credit Card payment
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        context.executePayment(5500.00);
        
        System.out.println("=============================================");

        // Switch to Upi payment
        context.setPaymentStrategy(new UpiPayment("javaFseuser@example.com"));
        context.executePayment(18500.50);
    }

}
