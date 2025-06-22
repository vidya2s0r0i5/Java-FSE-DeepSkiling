package module1.design_Patterns_and_Principles.DependencyInversionPrinciple;

public class CustomerService {
	private CustomerRepository repository;

    // Constructor Injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void showCustomerDetails(String id) {
        String customer = repository.findCustomerById(id);
        System.out.println("Customer Found: " + customer);
    }

}
