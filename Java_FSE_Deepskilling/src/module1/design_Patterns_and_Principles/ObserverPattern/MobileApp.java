package module1.design_Patterns_and_Principles.ObserverPattern;

public class MobileApp implements Observer{
	 private String name;

	    public MobileApp(String name) {
	        this.name = name;
	    }

	    @Override
	    public void update(double price) {
	        System.out.println("MobileApp " + name + ": Stock price updated to ₹" + price);
	    }
}
