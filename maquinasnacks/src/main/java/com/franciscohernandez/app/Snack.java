package com.franciscohernandez.app;

import java.io.Serializable;
import java.util.Objects;

public class Snack implements Serializable {
    private static int contadorSnacks = 0;
    private int idSnack;
    private String nombre;
    private double precio;

    public Snack() {
        this.idSnack = ++Snack.contadorSnacks;
    }

    public Snack(String nombre, double precio) {
        this(); // Debe ser la primera instrucción, llama al constructor vacío
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getIdSnack() {
        return this.idSnack;
    }

    public static int getContadorSnacks() {
        return contadorSnacks;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Snack [idSnack=" + idSnack + ", nombre=" + nombre + ", precio=" + precio + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Snack snack = (Snack) obj;
        return this.idSnack == snack.idSnack && Double.compare(snack.precio, precio) == 0
                && Objects.equals(nombre, snack.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSnack, nombre, precio);
    }
}
