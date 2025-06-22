package module1.design_Patterns_and_Principles.ProxyPattern;

public class ProxyImage implements Image{
	private String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);  // Lazy initialization
        } else {
            System.out.println("Using cached image in this proxy: " + filename);
        }

        realImage.display();
    }

}
