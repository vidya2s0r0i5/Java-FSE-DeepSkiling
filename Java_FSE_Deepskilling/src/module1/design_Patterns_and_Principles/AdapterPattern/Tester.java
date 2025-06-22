package module1.design_Patterns_and_Principles.AdapterPattern;

public class Tester {
	
	    public static void main(String[] args) {
	        // Using PayPal
	        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPal());
	        paypalProcessor.processPayment(11500.00);
 
	        System.out.println("----------------------");
	        // Using gpay
	        PaymentProcessor gpayProcessor = new GpayAdapter(new Gpay());
	        gpayProcessor.processPayment(9750.50);
	    }
	}



