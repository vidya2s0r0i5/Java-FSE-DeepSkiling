package module1.design_Patterns_and_Principles.FactoryMethodPattern;
public class PdfDocument implements Document{
	@Override
	public void open()
	{
	   System.out.println("Opened PDF Document");	
	}
}
