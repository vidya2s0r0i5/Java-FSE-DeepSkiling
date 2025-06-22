package module1.design_Patterns_and_Principles.ObserverPattern;

public class WebApp implements Observer{
	private String name;

    public WebApp(String name) {
        this.name = name;
    }

    @Override
    public void update(double price) {
        System.out.println("WebApp " + name + ": Stock price updated to ₹" + price);
    }

}
