package module1.design_Patterns_and_Principles.FactoryMethodPattern;

public class PdfFactory extends DocumentFactory{
	@Override
	public Document createDocument()
    {
    	System.out.println("PDF created");
    	return new PdfDocument();
    }
}
