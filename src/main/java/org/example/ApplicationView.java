package org.example;

import java.util.List;
import java.util.Scanner;

public class ApplicationView {

    private final BookManager bookManager = new BookManager();

    public ApplicationView() {

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
                    break;
                case 2:
                    System.out.println("Opción 2: Ver todos los libros ");
                    this.printList();
                    break;
                case 3:
                    java.lang.System.out.println("Opción 3: Eliminar libro");
                    this.printRemoveBookMenu();
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

        try {
            this.bookManager.createBook(addISBN, addTitulo, addAutor);
            System.out.println("El libro se ha añadido");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private void printList() {
        List <Book> bookList = bookManager.getAllBooks();
        for (Book book : bookList) {
            System.out.println(book.toString());
        }
    }

    private void printRemoveBookMenu() {
        System.out.println("Ingrese el ISBN del libro a eliminar (una letra seguida de tres números, por ejemplo, A123): ");
        String userISBN = sc.nextLine();

        try{
            this.bookManager.deleteBook(userISBN);
            System.out.println("El libro se ha eliminado.");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}