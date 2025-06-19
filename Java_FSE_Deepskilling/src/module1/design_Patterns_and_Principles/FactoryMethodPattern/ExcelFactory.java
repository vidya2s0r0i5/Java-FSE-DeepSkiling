package module1.design_Patterns_and_Principles.FactoryMethodPattern;

public class ExcelFactory extends DocumentFactory{
	@Override
	public Document createDocument()
    {
    	System.out.println("Excel created");
    	return new ExcelDocument();
    }
	
}
