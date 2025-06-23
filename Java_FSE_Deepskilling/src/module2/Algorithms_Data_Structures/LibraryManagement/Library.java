package module2.Algorithms_Data_Structures.LibraryManagement;

import java.util.Arrays;
import java.util.Comparator;

public class Library {

    // Linear Search by Title
    public Book linearSearch(Book[] books, String targetTitle) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(targetTitle)) {
                return b;
            }
        }
        return null;
    }

    // Binary Search by Title (Assumes sorted list)
    public Book binarySearch(Book[] books, String targetTitle) {
        Arrays.sort(books, Comparator.comparing(Book::getTitle)); // Ensure sorted

        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(targetTitle);
            if (cmp == 0) return books[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    //Print all books
    public void listBooks(Book[] books) {
        for (Book b : books) {
            System.out.println(b);
        }
    }
}

