package module2.Algorithms_Data_Structures.Sorting_Order;

public class Main {
    public static void main(String[] args) {
    	Order[] orders1 = {
    		    new Order(301, "Ravi", 750.50),
    		    new Order(302, "Sneha", 1200.00),
    		    new Order(303, "Ankit", 450.25),
    		    new Order(304, "Meena", 999.99),
    		    new Order(305, "Kiran", 1100.00)
    		};

        SortOrder sorter = new SortOrder();
//
//        System.out.println("Original Orders:");
//        sorter.printOrders(orders1);

        // Bubble Sort
        sorter.bubbleSort(orders1);
        System.out.println("\nBubble Sorted Orders by Price:");
        sorter.printOrders(orders1);

        // Reset array for quick sort
        Order []orders2 = new Order[] {
            new Order(201, "Alice", 499.99),
            new Order(202, "Bob", 1399.50),
            new Order(203, "Charlie", 299.99),
            new Order(204, "Diana", 999.99)
        };

        sorter.quickSort(orders2, 0, orders2.length - 1);
        System.out.println("\nQuick Sorted Orders by Price:");
        sorter.printOrders(orders2);
    }
}
