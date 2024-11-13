package org.example;

import java.util.List;

public interface BookRepository {
    void createBook(String addISBN, String addTitulo, String addAutor);

    boolean isbnIsValid(String addISBN);

    void deleteBook(String userISBN);

    List<Book> getAllBooks();
}
