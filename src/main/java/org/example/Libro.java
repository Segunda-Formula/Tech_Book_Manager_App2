package org.example;

public class Libro {
    private String ISBN;
    private String Titulo;
    private String Autor;

    public String getISBN() {
        return ISBN;
    }

    public Libro (String ISBN, String Titulo, String Autor){
        this.ISBN = ISBN;
        this.Titulo = Titulo;
        this.Autor = Autor;
    }



    @Override
    public String toString() {
        return
                "\nISBN: " + ISBN +
                " \nTítulo: " + Titulo +
                " \nAutor: " + Autor;
    }
}
