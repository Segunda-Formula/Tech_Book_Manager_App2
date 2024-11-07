package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    private ArrayList<Book> bookList = new ArrayList<>();

    public Application() {
        this.bookList.add(new Book("A123", "Java for dummies", "Burd Barry"));
        this.bookList.add(new Book("A124", "In Search of Lost Time", "Marcel Proust"));
        this.bookList.add(new Book("A125", "One Hundred Years of Solitude", "Gabriel García Márquez"));
    }

    Scanner sc = new Scanner(System.in);

    public void printMenu() {


        int opcion = 0;
        do {
            System.out.println("_____________________________________________________________________");
            java.lang.System.out.println("\nGestor de Libros Técnicos de Programación\n 1. Añadir libro\n 2. Ver todos los libros\n 3. Eliminar libro\n 4. Cambiar repositorio\n 5. Salir\n Seleccione una opción: ");

            java.lang.String input = sc.nextLine();

            try {
                opcion = java.lang.Integer.parseInt(input);
            } catch (java.lang.Exception ex) {
                java.lang.System.out.println("Opción inválida. Por favor, introduce un número del 1 al 5.");
                continue;
            }

            if (opcion < 1 || opcion > 5) {
                java.lang.System.out.println("Opción inválida. Por favor, seleccione una opción del 1 al 5.");
            }
            switch (opcion) {
                case 1:
                    java.lang.System.out.println("Opción 1: Añadir libro");
                    this.printAddBookMenu();
                    continue;
                case 2:
                    System.out.println("Opción 2: Ver todos los libros ");
                    this.printList();
                    break;
                case 3:
                    java.lang.System.out.println("Opción 3: Eliminar libro");
                    this.deleteBook();
                    break;
                case 4:
                    java.lang.System.out.println("Opción 4: Cambiar repositorio");
                    break;
                case 5:
                    java.lang.System.out.println("Opción 5: Salir");
                    break;
            }
        } while (opcion != 5);
    }

    private void printAddBookMenu() {
        System.out.println("Ingrese el ISBN");
        String addISBN = sc.nextLine();
        System.out.println("Ingrese el título");
        String addTitulo = sc.nextLine();
        System.out.println("Ingrese autor");
        String addAutor = sc.nextLine();
        
        this.createBook(addISBN, addTitulo, addAutor);
        
        

      //  Book nuevoBook = new Book(addISBN, addTitulo, addAutor);

      //  boolean isValid = true;
/*
        if (addISBN.isEmpty() || addTitulo.isEmpty() || addAutor.isEmpty()) {
            System.out.println("Todos los campos son obligatorios. Por favor, intente nuevamente.");
            isValid = false;
        }
        for (Book book : bookList) {
            if (book.getISBN().equals(addISBN)) {
                System.out.println("Ya existe un libro con ese ISBN. No se puede añadir el libro.");
                isValid = false;
            }
        }




        if (isValid) {
            bookList.add(nuevoBook);
            System.out.println("Libro añadido correctamente");
        }  */
    }

    private void createBook(String addISBN, String addTitulo, String addAutor) {
        Book book = new Book(addISBN, addTitulo, addAutor);
        bookList.add(book);

    }

    private void printList() {
        if (bookList.isEmpty()) System.out.println("No hay libros en la colección.");
        for (Book book : bookList) {
            System.out.println(book.toString());
        }
    }

    private boolean isbnIsValid(String userISBN) {
        String patron = "^[A-Za-z]\\d{3}$";
        return userISBN.matches(patron);
    }

    private void deleteBook() {
        System.out.println("Ingrese el ISBN del libro a eliminar (una letra seguida de tres números, por ejemplo, A123): ");
        String userISBN = sc.nextLine();
        if (!isbnIsValid(userISBN)) {
            System.out.println("ISBN inválido. Debe ser una letra seguida de tres números (por ejemplo, A123).");
            return;
        }
        boolean isDeleted = bookList.removeIf(book -> book.getISBN().equalsIgnoreCase(userISBN));
        if (isDeleted) {
            System.out.println("Libro eliminado con éxito");
        }
    }
}