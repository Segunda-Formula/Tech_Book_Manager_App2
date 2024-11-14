package org.example.logic;

import org.example.persistance.MySQLBookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookManager {
    private BookRepository bookRepository;

    public BookManager(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

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
        bookRepository.deleteByIsbn(userISBN);
    }


    public List<Book> getAllBooks() {return bookRepository.findAll();}

    public void changeRepository(BookRepository newRepository){
        this.bookRepository = newRepository;
    }

}
