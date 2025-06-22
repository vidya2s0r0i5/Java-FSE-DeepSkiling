package module1.design_Patterns_and_Principles.AdapterPattern;

public class PayPal {
    public void sendPayment(double amount) {
        System.out.println("Paid ₹" + amount + " via PayPal.");
    }
}

