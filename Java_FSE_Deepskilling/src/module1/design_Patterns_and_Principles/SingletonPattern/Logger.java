package module1.design_Patterns_and_Principles.SingletonPattern;

public class Logger {
     
	private static Logger l;
	private Logger() {
	  
		System.out.println("Private constructor of Logger class");
	}
	
	//helper method
	public static Logger getLogger()
	{
		if(l==null)
		{
			l=new Logger();// lazy instantiation
		
		}
		return l;
	}
	// non static method to test 
	public void display(String msg)
	{
		System.out.println("Message:"+msg);
	}
	
	

}
