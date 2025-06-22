package module1.design_Patterns_and_Principles.MVCPattern;

public class Tester {
	public static void main(String[] args) {
        // Create model
        Student student = new Student("Abbay", "S101", "A");

        // Create view
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(student, view);

        // Display initial student info
        controller.updateView();

        // Update student info via controller
        controller.setStudentName("Abbay Sharma");
        controller.setStudentGrade("A+");

        System.out.println("\nUpdated Student Details:");
        controller.updateView();
    }

}
