package module2.Algorithms_Data_Structures.InventoryManagementSystem;
public class Main {
    public static void main(String[] args) {
        InventoryService service = new InventoryService();

        service.addProduct(new Product(1, "Mouse", 90, 299.99));
        service.addProduct(new Product(2, "Keyboard", 130, 499.99));

        service.listAllProducts();
        service.updateProduct(1, 40, 399);
        service.deleteProduct(2);
        
        System.out.println("\nUpdated\n");
        service.listAllProducts();
    }
}
