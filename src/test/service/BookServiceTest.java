package test.service;

import model.Book;
import service.BookService;
import exception.BookNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {
    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookService = new BookService();
    }

    @Test
    void testAddBook() {
        Book book = new Book("1", "Java Basics", "John Doe", "Programming", "Available");
        bookService.addBook(book);
        assertEquals(1, bookService.getAllBooks().size());
    }

    @Test
    void testSearchBookById() {
        Book book = new Book("2", "Python Basics", "Jane Doe", "Programming", "Available");
        bookService.addBook(book);
        assertNotNull(bookService.searchBookById("2"));
    }

    @Test
    void testDeleteBook() {
        Book book = new Book("3", "C++ Basics", "Alice", "Programming", "Available");
        bookService.addBook(book);
        bookService.deleteBook("3");
        assertThrows(BookNotFoundException.class, () -> bookService.searchBookById("3"));
    }
}
