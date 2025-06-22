package module2.Algorithms_Data_Structures.InventoryManagementSystem;
import java.util.HashMap;

public class InventoryService {
    private HashMap<Integer, Product> inventory;

    public InventoryService() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(int productId, int newQty, double newPrice) {
        Product p = inventory.get(productId);
        if (p != null) {
            p.setQuantity(newQty);
            p.setPrice(newPrice);
        }
    }

    public void deleteProduct(int productId) {
        inventory.remove(productId);
    }

    public Product getProduct(int productId) {
        return inventory.get(productId);
    }

    public void listAllProducts() {
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }
}
