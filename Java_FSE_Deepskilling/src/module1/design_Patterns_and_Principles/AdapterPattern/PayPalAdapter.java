package module1.design_Patterns_and_Principles.AdapterPattern;

public class PayPalAdapter implements PaymentProcessor{
	
	
	    private PayPal payPal;

	    public PayPalAdapter(PayPal payPal) {
	        this.payPal = payPal;
	    }

	    @Override
	    public void processPayment(double amount) {
	        payPal.sendPayment(amount);
	    }
	}



