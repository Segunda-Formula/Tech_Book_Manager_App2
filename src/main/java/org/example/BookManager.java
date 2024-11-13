package org.example;

import java.util.ArrayList;
import java.util.List;

public class BookManager implements BookRepository {
    public ArrayList<Book> bookList = new ArrayList<Book>();

    @Override
    public void createBook(String addISBN, String addTitulo, String addAutor) {

        for (Book book : bookList) {
            if (addISBN.equals(book.getIsbn())) {
                throw new IllegalArgumentException("Este libro ya existe");
            }
        }
        if (!isbnIsValid(addISBN)) {
            throw new IllegalArgumentException("ISBN inválido. Debe ser una letra seguida de tres números (por ejemplo, A123).");
        }

        Book book = new Book(addISBN, addTitulo, addAutor);
        bookList.add(book);
    }

    @Override
    public boolean isbnIsValid(String addISBN) {
        String patron = "^[A-Za-z]\\d{3}$";
        return addISBN.matches(patron);
    }

    @Override
    public void deleteBook(String userISBN) {

        bookList.removeIf(book -> book.getIsbn().equalsIgnoreCase(userISBN));
    }

    @Override
    public List<Book> getAllBooks() {
        return this.bookList;
    }
}
