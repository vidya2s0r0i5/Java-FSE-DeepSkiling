package module1.design_Patterns_and_Principles.DependencyInversionPrinciple;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(String id) {
        // Dummy data
        return "Customer[ID: " + id + ", Name: Hinata]";
    }
}