package org.example;

public class Book {
    private String isbn;
    private String title;
    private String author;

    public Book(String ISBN, String title, String author){
        this.isbn = ISBN;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return
                "\nISBN: " + isbn +
                " \nTítulo: " + title +
                " \nAutor: " + author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
