package com.franciscohernandez.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnacks {
    public static void main(String[] args) {
        maquinaSnacks();
    }

    public static void maquinaSnacks() {
        var salir = false;
        var consola = new Scanner(System.in);
        List<Snack> productos = new ArrayList<>();
        System.out.println("*** Máquina de snacks ***");
        Snacks.mostrarSnacks(); // Mostrar los snacks disponibles

        while (!salir) {
            try {
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(opcion, consola, productos);
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            } finally {
                System.out.println(); // Imprime un salto de línea con cada iteración
            }
        }
    }

    private static int mostrarMenu(Scanner consola) {
        System.out.print("""
                Menú:
                1. Comprar snack
                2. Mostrar ticket
                3. Agregar nuevo snack
                4. Salir
                Elige una opción: \s""");
        // Leer la opción del usuario
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(int opcion, Scanner consola, List<Snack> productos) {
        var salir = false;
        switch (opcion) {
            case 1 -> comprarSnack(consola, productos);
            case 2 -> mostrarTicket(productos);
            case 3 -> agregarSnack(consola);
            case 4 -> {
                System.out.println("Regresa pronto...");
                salir = true;
            }
            default -> System.out.println("Opción no válida: " + opcion);
        }
        return salir;
    }

    private static void comprarSnack(Scanner consola, List<Snack> productos) {
        System.out.println("¿Qué snack deseas comprar (id)?");
        var idSnack = Integer.parseInt(consola.nextLine());
        //Validar que el id del snack exista
        var snackEncontrado = false;
        for (Snack snack : Snacks.getSnacks()) {
            if (snack.getIdSnack() == idSnack) {
                // Agregar el snack a la lista de productos
                productos.add(snack);
                System.out.println("Snack agregado al carrito: " + snack);
                snackEncontrado = true;
                break;
            }
        }
        if (!snackEncontrado) {
            System.out.println("El snack no existe: " + idSnack);
        }
    }

    private static void mostrarTicket(List<Snack> productos) {
        var ticket = "*** Ticket de Venta ***";
        var total = 0.0;
        
        for (Snack producto : productos) {
            ticket += "\n\t- " + producto.getNombre() + " - $" + producto.getPrecio();
            total += producto.getPrecio();
        }
        ticket += "\n\tTotal -> $"+ total;
        System.out.println(ticket);
    }

    private static void agregarSnack(Scanner consola) {
        System.out.print("Ingresa el nombre del snack: ");
        var nombre = consola.nextLine();
        System.out.print("Ingresa el precio del snack: ");
        var precio = Double.parseDouble(consola.nextLine());
        Snacks.agregarSnack(new Snack(nombre, precio));
        System.out.println("Snack agregado correctamente");
        Snacks.mostrarSnacks();
    }
}
