package module1.design_Patterns_and_Principles.FactoryMethodPattern;

public class Test {
      public static void main(String[] args) {
	   // to verify Factory pattern
    	DocumentFactory d1=new WordFactory();
    	Document word= d1.createDocument();
    	word.open();
    	
    	System.out.println("===================");  
    	
    	DocumentFactory d2=new PdfFactory();
    	Document pdf= d2.createDocument();
    	pdf.open();
    	
    	System.out.println("==================="); 
    	
    	DocumentFactory d3=new ExcelFactory();
    	Document excel= d3.createDocument();
    	excel.open();
    	
    	System.out.println("===================");  
   }
}
