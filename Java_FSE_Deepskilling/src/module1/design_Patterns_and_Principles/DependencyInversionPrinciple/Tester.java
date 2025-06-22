package module1.design_Patterns_and_Principles.DependencyInversionPrinciple;

public class Tester {

	public static void main(String[] args) {
        // Create repository implementation
        CustomerRepository repo = new CustomerRepositoryImpl();

        // Inject dependency into service using constructor
        CustomerService service = new CustomerService(repo);

        // Use the service
        service.showCustomerDetails("C1008791");
    }
}
