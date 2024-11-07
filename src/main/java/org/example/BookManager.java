package org.example;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    public ArrayList<Book> bookList = new ArrayList<Book>();

    public void createBook(String addISBN, String addTitulo, String addAutor) {

        for (Book book : bookList) {
            if (addISBN.equals(book.getISBN())) {
                throw new IllegalArgumentException("Este libro ya existe");
            }
        }
        if (!isbnIsValid(addISBN)) {
            throw new IllegalArgumentException("ISBN inválido. Debe ser una letra seguida de tres números (por ejemplo, A123).");
        }

        Book book = new Book(addISBN, addTitulo, addAutor);
        bookList.add(book);
    }

    public boolean isbnIsValid(String addISBN) {
        String patron = "^[A-Za-z]\\d{3}$";
        return addISBN.matches(patron);
    }

    public void deleteBook(String userISBN) {

        bookList.removeIf(book -> book.getISBN().equalsIgnoreCase(userISBN));
    }

    public List<Book> getAllBooks() {
        return this.bookList;
    }
}
