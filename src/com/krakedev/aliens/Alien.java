package com.krakedev.aliens;

public class Alien {
    //ATRIBUTOS
    private int tamanio;
    private String color;
    private int numeroOjos;
    private int numeroBrazos;
    private int numeroPiernas;
    private double precioExtremidades;
    private double precioOjo;
    private double precioCuerpo;

    //CONSTRUCTORES
    public Alien (int tamanio, String color) {
        this.tamanio = tamanio;
        this.color = color;

        //validaciones
        if (tamanio < 5 ){
            this.tamanio = 5;
            System.out.println("El tamaño del alien NO debe ser menor a 5cm.");
        } else if (tamanio > 30 ){
            this.tamanio = 30;
            System.out.println("El tamaño del alien NO debe ser mayor a 30cm.");
        }

        //calculos
        this.precioExtremidades = 0.1 * this.tamanio;
        this.precioOjo = 0.05 * this.tamanio;
        this.precioCuerpo = 0.2 * this.tamanio;


    }

    //GETTERS AND SETTERS
    public int getTamanio() {
        return tamanio;
    }

    public String getColor() {
        return color;
    }

    public int getNumeroOjos() {
        return numeroOjos;
    }

    public int getNumeroBrazos() {
        return numeroBrazos;
    }

    public int getNumeroPiernas() {
        return numeroPiernas;
    }

    public double getPrecioExtremidades() {
        return precioExtremidades;
    }

    public double getPrecioOjo() {
        return precioOjo;
    }

    public double getPrecioCuerpo() {
        return precioCuerpo;
    }

    //METODOS
    public void imprimir() {
        String mensaje = "Tamaño: " +  tamanio +
                "\nColor: " + color +
                "\nOjos: " + numeroOjos +
                "\nBrazos: " + numeroBrazos +
                "\nPiernas: " + numeroPiernas +
                "\nPrecio Extremidades: $" + precioExtremidades +
                "\nPrecio Ojos: $" + precioOjo +
                "\nPrecio Cuerpo: $" + precioCuerpo;

        System.out.println(mensaje);
    }

    public boolean agregarBrazos (int numeroBrazos) {
        int extremidades = numeroBrazos + this.numeroPiernas;
        if (extremidades > 0 && extremidades <= 10) {
            this.numeroBrazos = numeroBrazos;
            return true;
        } else {
            System.out.println("El Alien puede tener un máxmo de 10 extremidades (brazos+piernas)");
            this.numeroBrazos = 0;
            return false;
        }
    }

    public boolean agregarPiernas (int numeroPiernas) {
        int extremidades = numeroPiernas + this.numeroBrazos;
        if (extremidades > 0 && extremidades <= 10) {
            this.numeroPiernas = numeroPiernas;
            return true;
        } else {
            System.out.println("El Alien puede tener un máxmo de 10 extremidades (brazos+piernas)");
            this.numeroPiernas = 0;
            return false;
        }
    }
}
