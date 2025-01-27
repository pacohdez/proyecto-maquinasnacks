package com.franciscohernandez.app;

import java.util.ArrayList;
import java.util.List;

public class Snacks {
    private static final List<Snack> SNACKS;

    // Bloque static para inicializar la lista de snacks
    static {
        SNACKS = new ArrayList<>();
        SNACKS.add(new Snack("Papas", 70.0));
        SNACKS.add(new Snack("Refresco", 50.0));
        SNACKS.add(new Snack("Sandwich", 100.0));
    }

    public static void agregarSnack(Snack snack) {
        SNACKS.add(snack);
    }

    public static void mostrarSnacks() {
        var inventarioSnacks = "";
        for (Snack snack : SNACKS) {
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println("--- Snacks en el inventario ---");
        System.out.println(inventarioSnacks);
    }

    public static List<Snack> getSnacks() {
        return SNACKS;
    }
}
