package module1.design_Patterns_and_Principles.DecoratorPattern;

public class EmailNotifier implements Notifier {
	@Override
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }

}
