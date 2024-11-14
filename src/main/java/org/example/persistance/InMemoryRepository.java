package org.example.persistance;

import org.example.logic.BookRepository;
import org.example.logic.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryRepository implements BookRepository {
    private static List<Book> booksDB = new ArrayList<>();

    @Override
    public void save(Book book) {
        booksDB.add(book);
    }

    @Override
    public List<Book> findAll() {
        return booksDB;
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        for (Book book : booksDB) {
            if(book.getIsbn().equals(isbn)) {
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    @Override
    public void deleteByIsbn(String isbn) {
        booksDB.removeIf(book -> book.getIsbn().equals(isbn));
    }
}
