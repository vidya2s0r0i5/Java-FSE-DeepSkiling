package module1.design_Patterns_and_Principles.CommandPattern;

public class LightOffCommand implements Command {
	private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

}
