package module1.design_Patterns_and_Principles.BuilderPattern;

public class Computer {
	private int ram;
	private String cpu;
	private int storage;
	
	private Computer(Builder b) {
		this.ram = b.ram;
		this.cpu = b.cpu;
		this.storage = b.storage;
	}

	public static class Builder{
		static int ram;
		static String cpu;
		static int storage;
		
		public Builder setRam(int ram)
		{
			Builder.ram=ram;
			return this;
		}

		
		public Builder setCpu(String cpu) {
			Builder.cpu = cpu;
			return this;
		}

		

		public Builder setStorage(int storage) {
			Builder.storage = storage;
			return this;
		}
		
		public Computer build()
		{
			return new Computer(this);
		}
	}
	
	

}
