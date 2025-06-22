package module1.design_Patterns_and_Principles.ProxyPattern;

public class Tester {
	 public static void main(String[] args) {
	        Image img1 = new ProxyImage("mountains.jpg");
	        Image img2 = new ProxyImage("ocean.jpg");

	        System.out.println("--- First time displaying mountains.jpg ---");
	        img1.display();  // Loads and displays
            System.out.println("===============================================");
	        
	        System.out.println("--- Second time displaying mountains.jpg ---");
	        img1.display();  // Uses cached in this proxy

            System.out.println("===============================================");
	        System.out.println("--- Displaying ocean.jpg ---");
	        img2.display();  // Loads and displays
	        System.out.println("===============================================");
}

}
