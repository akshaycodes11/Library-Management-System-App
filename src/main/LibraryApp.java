package main;

import model.Book;
import service.BookService;
import java.util.Scanner;

public class LibraryApp {
    private static final BookService bookService = new BookService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Search Book by Title");
            System.out.println("5. Update Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> addBook();
                case "2" -> viewAllBooks();
                case "3" -> searchBookById();
                case "4" -> searchBookByTitle();
                case "5" -> updateBook();
                case "6" -> deleteBook();
                case "7" -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter Availability (Available/Checked Out): ");
        String availability = scanner.nextLine();

        try {
            bookService.addBook(new Book(id, title, author, genre, availability));
            System.out.println("Book added successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewAllBooks() {
        bookService.getAllBooks().forEach(System.out::println);
    }

    private static void searchBookById() {
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine();
        try {
            System.out.println(bookService.searchBookById(id));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void searchBookByTitle() {
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        bookService.searchBooksByTitle(title).forEach(System.out::println);
    }

    private static void updateBook() {
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine();
        System.out.print("New Title (leave blank to skip): ");
        String title = scanner.nextLine();
        System.out.print("New Author (leave blank to skip): ");
        String author = scanner.nextLine();
        System.out.print("New Availability (Available/Checked Out): ");
        String availability = scanner.nextLine();

        try {
            bookService.updateBook(id, title, author, availability);
            System.out.println("Book updated successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void deleteBook() {
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine();
        try {
            bookService.deleteBook(id);
            System.out.println("Book deleted successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
