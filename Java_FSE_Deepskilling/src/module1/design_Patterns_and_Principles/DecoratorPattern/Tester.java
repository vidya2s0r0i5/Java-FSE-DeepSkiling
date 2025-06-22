package module1.design_Patterns_and_Principles.DecoratorPattern;

public class Tester {
	public static void main(String[] args) {
        // Base notifier (email only)
        Notifier notifier = new EmailNotifier();

        // Add SMS functionality
        notifier = new SMSNotifierDecorator(notifier);
         
        // Add Slack functionality
        notifier = new SlackNotifierDecorator(notifier);

        // Send message via all channels
        notifier.send("System Alert: High CPU usage detected.\n");
    }

}
