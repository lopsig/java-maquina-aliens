package com.krakedev.aliens;

public class Alien {
    //ATRIBUTOS
    private int tamanio;
    private String color;
    private int numeroOjos;
    private int numeroBrazos;
    private int numeroPies;
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
        this.precioCuerpo = 0.2 * tamanio;
        this.precioExtremidades = 0.1 * tamanio;
        this.precioOjo = 0.05 * tamanio;


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

    public int getNumeroPies() {
        return numeroPies;
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
                "\nPies: " + numeroPies +
                "\nPrecio Extremidades: $" + precioExtremidades +
                "\nPrecio Ojos: $" + precioOjo +
                "\nPrecio Cuerpo: " + precioCuerpo;

        System.out.println(mensaje);

    }
}
