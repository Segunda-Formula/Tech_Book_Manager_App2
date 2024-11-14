package org.example.logic;

public class Book {
    private String isbn;
    private String title;
    private String author;

    public Book(String ISBN, String title, String author){

        if (!isbnIsValid(ISBN)) {
            throw new IllegalArgumentException("ISBN inválido. Debe ser una letra seguida de tres números (por ejemplo, A123).");
        }

        if(title == null || title.isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }

        if(author == null || author.isEmpty()) {
            throw new IllegalArgumentException("El Autor no puede estar vacío");
        }

        this.isbn = ISBN;
        this.title = title;
        this.author = author;
    }

    public boolean isbnIsValid(String addISBN) {
        String patron = "^[A-Za-z]\\d{3}$";
        return addISBN.matches(patron);
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
