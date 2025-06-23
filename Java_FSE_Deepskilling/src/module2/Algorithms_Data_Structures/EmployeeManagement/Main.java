package module2.Algorithms_Data_Structures.EmployeeManagement;

public class Main {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService(10);

        service.addEmployee(new Employee(101, "Ravi ", "Developer", 65000));
        service.addEmployee(new Employee(102, "Sneha ", "Designer", 58000));
        service.addEmployee(new Employee(103, "Mehta", "Manager", 85000));
        service.addEmployee(new Employee(104, "Meena", "QA Engineer", 55000));

        System.out.println("\nAll Employees:");
        service.listEmployees();

        System.out.println("\nSearching for Employee ID 2:");
        Employee found = service.searchEmployee(102);
        System.out.println(found != null ? found : "Employee not found");

        System.out.println("\nDeleting Employee ID 2:");
        boolean deleted = service.deleteEmployee(102);
        System.out.println(deleted ? "Deleted successfully" : "Employee not found");

        System.out.println("\nUpdated Employee List:");
        service.listEmployees();
    }
}
