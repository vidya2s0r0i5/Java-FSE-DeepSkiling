package module1.design_Patterns_and_Principles.AdapterPattern;

public class GpayAdapter implements PaymentProcessor{
	
	    private Gpay gpay;

	    public GpayAdapter(Gpay gpay) {
	        this.gpay = gpay;
	    }

	    @Override
	    public void processPayment(double amount) {
	        gpay.makePayment(amount);
	    }
	}


