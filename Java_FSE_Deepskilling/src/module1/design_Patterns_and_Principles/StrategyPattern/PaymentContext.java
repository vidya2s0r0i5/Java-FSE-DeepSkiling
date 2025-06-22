package module1.design_Patterns_and_Principles.StrategyPattern;

public class PaymentContext {
	 private PaymentStrategy strategy;

	    // Set strategy dynamically
	    public void setPaymentStrategy(PaymentStrategy strategy) {
	        this.strategy = strategy;
	    }

	    public void executePayment(double amount) {
	        if (strategy == null) {
	            System.out.println("No payment strategy selected!");
	        } else {
	            strategy.pay(amount);
	        }
	    }
}
