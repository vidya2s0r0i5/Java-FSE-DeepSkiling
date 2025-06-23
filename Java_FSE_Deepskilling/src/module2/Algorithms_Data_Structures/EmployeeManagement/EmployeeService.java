package module2.Algorithms_Data_Structures.EmployeeManagement;

public class EmployeeService {
    private Employee[] employees;
    private int size;

    public EmployeeService(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add Employee
    public void addEmployee(Employee emp) {
        if (size < employees.length) {
            employees[size++] = emp;
        } else {
            System.out.println("Employee array is full!");
        }
    }

    // Search Employee by ID
    public Employee searchEmployee(int empId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == empId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse All Employees
    public void listEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete Employee by ID
    public boolean deleteEmployee(int empId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == empId) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;
                return true;
            }
        }
        return false;
    }
}

