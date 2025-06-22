package module1.design_Patterns_and_Principles.DecoratorPattern;

public class SlackNotifierDecorator extends NotifierDecorator {
	public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlack(message);
    }

    private void sendSlack(String message) {
        System.out.println("Slack message sent: " + message);
    }

}
