package module1.design_Patterns_and_Principles.BuilderPattern;

public class Tester {
	public static void main(String[] args) {
		
		Computer pc= new Computer.Builder().setCpu("intel 8").setRam(8).setStorage(128).build();
		System.out.println(pc);
		
		System.out.println("\n-------------------------------\n");
		Computer gamingPc=new Computer.Builder().setCpu("Intel i9").setRam(16).setStorage(256).build();
		System.out.println(gamingPc);
		
	}

}
