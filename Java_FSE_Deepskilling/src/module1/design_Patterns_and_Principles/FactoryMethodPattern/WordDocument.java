package module1.design_Patterns_and_Principles.FactoryMethodPattern;
public class WordDocument implements Document {
	@Override
	public void open()
	{
	   System.out.println("Opened Word Document");	
	}
}
