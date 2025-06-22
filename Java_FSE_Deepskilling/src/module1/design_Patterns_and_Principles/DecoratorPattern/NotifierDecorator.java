package module1.design_Patterns_and_Principles.DecoratorPattern;

public abstract class NotifierDecorator implements Notifier 
{
	protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }

}
