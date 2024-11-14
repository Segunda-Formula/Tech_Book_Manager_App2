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
    void findAll() {
        // GIVEN


        //WHEN


        //THEN
    }

    @org.junit.jupiter.api.Test
    void findByIsbn() {
    }

    @org.junit.jupiter.api.Test
    void deleteByIsbn() {
    }
}