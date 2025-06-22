package module1.design_Patterns_and_Principles.DecoratorPattern;

public class SMSNotifierDecorator extends NotifierDecorator{
	 public SMSNotifierDecorator(Notifier notifier) {
	        super(notifier);
	    }

	    @Override
	    public void send(String message) {
	        super.send(message);
	        sendSMS(message);
	    }

	    private void sendSMS(String message) {
	        System.out.println("SMS sent: " + message);
	    }

}
