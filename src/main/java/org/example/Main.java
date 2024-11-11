package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
       // ApplicationView app = new ApplicationView();
       // app.printMenu();

        MySQLBookRepository bookRepository = new MySQLBookRepository();

        List<Book> list = bookRepository.findAll();
        for (Book book : list) {
            System.out.println(book);
        }
    }
}