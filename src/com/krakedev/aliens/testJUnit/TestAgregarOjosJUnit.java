package com.krakedev.aliens.testJUnit;

import com.krakedev.aliens.Alien;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestAgregarOjosJUnit {

    //CASO VALIDO TAMAÑO: 5 - 10, OJOS: 3
    @Test
    public void testAgregarOjosValido1() {
        Alien alien = new Alien(5, "Gris");

        boolean resultadoOjos = alien.agregarOjos(3);
        assertTrue(resultadoOjos);
        assertEquals(3, alien.getNumeroOjos());
    }

    //CASO INVALIDO TAMAÑO: 10 - 20, OJOS: 7
    @Test
    public void testAgregarOjosInvalido() {
        Alien alien = new Alien(15, "Verde");

        boolean resultadoOjos = alien.agregarOjos(7);
        assertFalse(resultadoOjos);
        assertEquals(0, alien.getNumeroOjos());
    }

    //CASO VALIDO TAMAÑO: 20 - 30, OJOS: 5
    @Test
    public void testAgregarOjosValido2() {
        Alien alien = new Alien(25, "Azul");

        boolean resultadoOjos = alien.agregarOjos(5);
        assertTrue(resultadoOjos);
        assertEquals(5, alien.getNumeroOjos());
    }


}