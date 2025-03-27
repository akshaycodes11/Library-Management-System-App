package service;

import model.Book;
import exception.BookNotFoundException;
import java.util.*;

public class BookService {
    private final Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        if (books.containsKey(book.getId())) {
            throw new IllegalArgumentException("Book ID already exists.");
        }
        books.put(book.getId(), book);
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public Book searchBookById(String id) {
        return Optional.ofNullable(books.get(id))
                .orElseThrow(() -> new BookNotFoundException("Book with ID " + id + " not found."));
    }

    public List<Book> searchBooksByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public void updateBook(String id, String title, String author, String availabilityStatus) {
        Book book = searchBookById(id);
        if (title != null && !title.isEmpty()) book.setTitle(title);
        if (author != null && !author.isEmpty()) book.setAuthor(author);
        if (availabilityStatus != null) book.setAvailabilityStatus(availabilityStatus);
    }

    public void deleteBook(String id) {
        if (books.remove(id) == null) {
            throw new BookNotFoundException("Book with ID " + id + " not found.");
        }
    }
}
