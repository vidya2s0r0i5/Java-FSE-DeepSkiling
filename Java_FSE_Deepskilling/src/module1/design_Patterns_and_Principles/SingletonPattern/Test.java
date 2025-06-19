package module1.design_Patterns_and_Principles.SingletonPattern;

public class Test {
	
	public static void main(String[] args) {
		
		Logger l1=Logger.getLogger();
		l1.display("First logger");
		
		Logger l2=Logger.getLogger();

		l2.display("Second logger");
		
		// verifying singleton pattern
		
		System.out.println("Verifying Singleton");
		if(l1==l2) //compare address
		{

			System.out.println("Only one instance exists");
		}
		else
			System.out.println("Multiple instance----Singleton not achieved");
	}

}
