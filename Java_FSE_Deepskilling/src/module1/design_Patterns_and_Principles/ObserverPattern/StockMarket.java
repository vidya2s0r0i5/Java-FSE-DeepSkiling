package module1.design_Patterns_and_Principles.ObserverPattern;

	import java.util.ArrayList;
	import java.util.List;

	public class StockMarket implements Stock {
	    private List<Observer> observers = new ArrayList<>();
	    private double stockPrice;

	    @Override
	    public void registerObserver(Observer observer) {
	        observers.add(observer);
	    }

	    @Override
	    public void removeObserver(Observer observer) {
	        observers.remove(observer);
	    }

	    @Override
	    public void notifyObservers() {
	        for (Observer obs : observers) {
	            obs.update(stockPrice);
	        }
	    }

	    public void setStockPrice(double price) {
	        this.stockPrice = price;
	        notifyObservers();
	    }
	}



