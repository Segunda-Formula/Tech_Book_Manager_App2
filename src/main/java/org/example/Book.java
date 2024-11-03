package org.example;

public class Book {
    private String ISBN;
    private String Title;
    private String Author;

    public String getISBN() {
        return ISBN;
    }

    public Book(String ISBN, String title, String author){
        this.ISBN = ISBN;
        this.Title = title;
        this.Author = author;
    }

    @Override
    public String toString() {
        return
                "\nISBN: " + ISBN +
                " \nTítulo: " + Title +
                " \nAutor: " + Author;
    }
}
