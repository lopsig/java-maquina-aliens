package com.krakedev.aliens.test;

import com.krakedev.aliens.Alien;

public class TestAgregarOjos {
    public static void main(String[] args) {
        //INSTANCIAS
        Alien alien1 = new Alien(5, "Gris");
        Alien alien2 = new Alien(15, "Verde");
        Alien alien3 = new Alien(25, "Azul");

        //METODOS
        System.out.println("--------ALIEN 1--------");
        alien1.agregarBrazos(2);
        alien1.agregarPiernas(5);
        alien1.agregarOjos(3);
        alien1.imprimir();

        System.out.println("--------ALIEN 2--------");
        alien2.agregarBrazos(7);
        alien2.agregarPiernas(3);
        alien2.agregarOjos(7);
        alien2.imprimir();

        System.out.println("--------ALIEN 3--------");
        alien3.agregarBrazos(8);
        alien3.agregarPiernas(1);
        alien3.agregarOjos(5);
        alien3.imprimir();
    }
}
