package org.example;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        ApplicationView app = new ApplicationView();
        app.printMenu();

        /*MySQLBookRepository bookRepository = new MySQLBookRepository();

        List<Book> list = bookRepository.findAll();
        for (Book book : list) {
            System.out.println(book);

             Book newBook2 = new Book("A130", "Title 5", "Author 5");

             bookRepository.save(newBook2);

       /* Optional<Book> optionalBook = bookRepository.findByIsbn("A130");
        if(optionalBook.isPresent()) {
            Book book = optionalBook.get();
            System.out.println(book);
        }

        if (optionalBook.isEmpty()) {
              System.out.println("El libro no existe");
            }
        }*/
        //bookRepository.deleteByIsbn("A123");*/
    }
    }
