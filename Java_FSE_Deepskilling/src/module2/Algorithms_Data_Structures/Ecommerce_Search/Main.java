package module2.Algorithms_Data_Structures.Ecommerce_Search;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Footwear"),
            new Product(103, "Phone", "Electronics"),
            new Product(104, "Book", "Stationery")
        };

        SearchingOperation search = new SearchingOperation();

        String target = "Phone";

        Product linearResult = search.linearSearch(products, target);
        System.out.println("Linear Search Result: " + (linearResult != null ? linearResult : "Product Not Found"));

        String target2 = "Book";
        Product binaryResult = search.binarySearch(products, target2);
        System.out.println("Binary Search Result: " + (binaryResult != null ? binaryResult : "Product Not Found"));
    }
}

