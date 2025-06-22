package module1.design_Patterns_and_Principles.ObserverPattern;

public interface Stock {
	void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();

}
