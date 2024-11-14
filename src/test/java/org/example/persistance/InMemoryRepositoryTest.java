package org.example.persistance;

import org.example.logic.Book;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryRepositoryTest {

    @org.junit.jupiter.api.Test
    void saveBookWhenIsCreated() {
        //GIVEN
        Book book = new Book("A140", "Title1", "Autor1");
        InMemoryRepository repository = new InMemoryRepository();

        //WHEN
        repository.save(book);
        List<Book> listBooks = repository.findAll();

        //THEN
        assertEquals(1, listBooks.size());
        assertEquals("A140", listBooks.getFirst().getIsbn());
        assertEquals("Autor1", listBooks.getFirst().getAuthor());
        assertEquals("Title1", listBooks.getFirst().getTitle());
    }

    @org.junit.jupiter.api.Test
    void findAllBooksInMemoryRepository() {
        // GIVEN
        Book book = new Book("A140", "Title1", "Autor1");
        Book book2 = new Book("A141", "Title2", "Autor2");
        InMemoryRepository repository = new InMemoryRepository();

        //WHEN
        repository.save(book);
        repository.save(book2);
        List<Book> listBooks = repository.findAll();

        //THEN
        assertEquals(2,listBooks.size());
    }

    @org.junit.jupiter.api.Test
    void findBookByIsbn() {
        //GIVEN
        Book book = new Book("A140", "Title1", "Autor1");
        InMemoryRepository repository = new InMemoryRepository();

        //WHEN
        repository.save(book);

        //THEN
        assertEquals("A140", book.getIsbn());

    }

    @org.junit.jupiter.api.Test
    void deleteBookByIsbn() {
        //GIVEN
        Book book = new Book("A140", "Title1", "Autor1");
        InMemoryRepository repository = new InMemoryRepository();

        //WHEN
        repository.deleteByIsbn("A140");
        List<Book> listBooks = repository.findAll();

        //THEN
        assertEquals(0,listBooks.size());
    }
}