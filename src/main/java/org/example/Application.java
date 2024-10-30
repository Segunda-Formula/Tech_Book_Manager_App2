package org.example;

import java.util.Scanner;

public class Application {
    public void printMenu() {
        Scanner sc = new Scanner(System.in);

        Libro libros = new Libro("A123", "Effective Java ", "Joshua Bloch ");

        int opcion = 0;
        do {
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
                    break;

                case 2:
                    System.out.println("Lista de libros: \n");
                    libros.showBooks();
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
}