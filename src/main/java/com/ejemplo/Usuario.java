package com.ejemplo;

public class Usuario {
    private String nombre;
    private double peso;

    public Usuario() {}

    public Usuario(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPeso(double peso) {
        // ERROR: En lugar de asignar el nuevo peso, se está restando 1kg.
        // this.peso -= 1;
        this.peso = peso;
    }
}
