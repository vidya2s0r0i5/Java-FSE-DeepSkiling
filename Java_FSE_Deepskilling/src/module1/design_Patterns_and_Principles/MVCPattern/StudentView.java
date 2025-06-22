package module1.design_Patterns_and_Principles.MVCPattern;

public class StudentView {
	public void displayStudentDetails(String name, String id, String grade) {
        System.out.println("=== Student Details ===");
        System.out.println("Name : " + name);
        System.out.println("ID   : " + id);
        System.out.println("Grade: " + grade);
    }
}
