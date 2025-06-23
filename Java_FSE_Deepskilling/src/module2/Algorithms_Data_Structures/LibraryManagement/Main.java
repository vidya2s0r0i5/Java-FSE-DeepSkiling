package module2.Algorithms_Data_Structures.LibraryManagement;

public class Main {
    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "The Alchemist", "Paulo Coelho"),
            new Book(2, "To Kill a Mockingbird", "Harper Lee"),
            new Book(3, "1984", "George Orwell"),
            new Book(4, "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book(5, "Moby Dick", "Herman Melville")
        };

        Library service = new Library();

        System.out.println("All Books:");
        service.listBooks(books);

        String searchTitle = "1984";

        Book linearResult = service.linearSearch(books, searchTitle);
        System.out.println("\nLinear Search Result: " + (linearResult != null ? linearResult : "Not Found"));

        searchTitle = "The Alchemist";
        Book binaryResult = service.binarySearch(books, searchTitle);
        System.out.println("Binary Search Result: " + (binaryResult != null ? binaryResult : "Not Found"));
    }
}

