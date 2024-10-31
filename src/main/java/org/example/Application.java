package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    private ArrayList<Libro> listaLibros = new ArrayList<>();

    public Application() {
        this.listaLibros.add(new Libro("A123", "Java for dummies", "Burd Barry"));
        this.listaLibros.add(new Libro("A124", "In Search of Lost Time", "Marcel Proust"));
        this.listaLibros.add(new Libro("A125", "One Hundred Years of Solitude", "Gabriel García Márquez"));
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
                    this.addLibro();
                    continue;
                case 2:
                    System.out.println("Opción 2: Ver todos los libros ");
                    this.printLista();
                    break;
                case 3:
                    java.lang.System.out.println("Opción 3: Eliminar libro");
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

    private void addLibro() {
        System.out.println("Ingrese el ISBN");
        String addISBN = sc.nextLine();
        System.out.println("Ingrese el título");
        String addTitulo = sc.nextLine();
        System.out.println("Ingrese autor");
        String addAutor = sc.nextLine();
        Libro nuevoLibro = new Libro(addISBN, addTitulo, addAutor);

        boolean isValid = true;

        if (addISBN.isEmpty() || addTitulo.isEmpty() || addAutor.isEmpty()){
            System.out.println("Todos los campos son obligatorios. Por favor, intente nuevamente.");
            isValid = false;
        }
        for (Libro libro : listaLibros) {
            if (libro.getISBN().equals(addISBN)){
                System.out.println("Ya existe un libro con ese ISBN. No se puede añadir el libro.");
                isValid = false;
            }
        }

        if (isValid) {
            listaLibros.add(nuevoLibro);
            System.out.println("Libro añadido correctamente");
        }
    }

    private void printLista() {
        if (listaLibros.isEmpty()) System.out.println("No hay libros en la colección.");
        for (Libro libro : listaLibros) {
            System.out.println(libro.toString());
        }
    }
}