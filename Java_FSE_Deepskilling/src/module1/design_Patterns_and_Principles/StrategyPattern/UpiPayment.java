package module1.design_Patterns_and_Principles.StrategyPattern;

public class UpiPayment implements PaymentStrategy{

	private String email;

    public UpiPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI: " + email);
    }
}
