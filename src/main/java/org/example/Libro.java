package org.example;

import java.security.PrivateKey;

public class Libro {
    private String ISBN;
    private String Titulo;
    private String Autor;

    public Libro (String ISBN, String Titulo, String Autor){
        this.ISBN = ISBN;
        this.Titulo = Titulo;
        this.Autor = Autor;
    }

    public void showBooks () {
        System.out.println("ISBN: " + this.ISBN + " Título: " + this.Titulo + " Autor: " + this.Autor);
    }


}
