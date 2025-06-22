package module1.design_Patterns_and_Principles.CommandPattern;

public class LightOnCommand implements Command {
	 private Light light;

	    public LightOnCommand(Light light) {
	        this.light = light;
	    }

	    @Override
	    public void execute() {
	        light.turnOn();
	    }
	

}
