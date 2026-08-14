package com.krakedev.aliens.test;

import com.krakedev.aliens.Alien;

public class TestConstructores {
    public static void main(String[] args) {
        //INSTANCIAS
        Alien alien1 = new Alien(1, "Gris");
        Alien alien2 = new Alien(15, "Verde");
        Alien alien3 = new Alien(50, "Azul");

        //VISUALIZACION
        System.out.println("--------ALIEN 1--------");
        alien1.imprimir();
        System.out.println("-----------------------");

        System.out.println("--------ALIEN 2--------");
        alien2.imprimir();
        System.out.println("-----------------------");

        System.out.println("--------ALIEN 3--------");
        alien3.imprimir();
        System.out.println("-----------------------");
    }
}
