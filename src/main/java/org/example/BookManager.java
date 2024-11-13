package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookManager {
    public ArrayList<Book> bookList = new ArrayList<Book>();
    private BookRepository bookRepository = new MySQLBookRepository();


    public void createBook(String addISBN, String addTitulo, String addAutor) {

        Optional <Book> optionalBook = bookRepository.findByIsbn(addISBN);

        if (optionalBook.isPresent()) {
            throw new IllegalArgumentException("Este libro ya existe");
        }

        if (!isbnIsValid(addISBN)) {
            throw new IllegalArgumentException("ISBN inválido. Debe ser una letra seguida de tres números (por ejemplo, A123).");
        }

        Book book = new Book(addISBN, addTitulo, addAutor);
        bookRepository.save(book);
    }


    public boolean isbnIsValid(String addISBN) {
        String patron = "^[A-Za-z]\\d{3}$";
        return addISBN.matches(patron);
    }


    public void deleteBook(String userISBN) {

        bookList.removeIf(book -> book.getIsbn().equalsIgnoreCase(userISBN));
    }


    public List<Book> getAllBooks() {
        return this.bookList;
    }
}
