package com.krakedev.aliens.testJUnit;

import com.krakedev.aliens.Alien;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestAgregarBrazosPiernasJUnit {

    //CASO INVALIDO
    @Test
    public void testAgregarBrazosPiernasCantidadNNegativa() {
        Alien alien = new Alien(5, "Gris");

        boolean resultadoBrazos = alien.agregarBrazos(-1);

        assertFalse(resultadoBrazos);
        assertEquals(0, alien.getNumeroBrazos());

        boolean resultadoPiernas = alien.agregarPiernas(5);
        assertTrue(resultadoPiernas);
        assertEquals(5, alien.getNumeroPiernas());
    }

    // CASO VALIDO
    @Test
    public void testAgregarBrazosPiernasValido() {
        Alien alien = new Alien(15, "Verde");

        boolean resultadoBrazos = alien.agregarBrazos(7);
        assertTrue(resultadoBrazos);
        assertEquals(7, alien.getNumeroBrazos());

        boolean resultadoPiernas = alien.agregarPiernas(3);
        assertTrue(resultadoPiernas);
        assertEquals(3, alien.getNumeroPiernas());

        assertEquals(10, alien.getNumeroBrazos() + alien.getNumeroPiernas());
    }

    // CASO MAYOR 10
    @Test
    void testAgregarBrazosPiernasExcedeLimite() {
        Alien alien = new Alien(25, "Azul");

        boolean resultadoBrazos = alien.agregarBrazos(8);
        assertTrue(resultadoBrazos);
        assertEquals(8, alien.getNumeroBrazos());

        boolean resultadoPiernas = alien.agregarPiernas(3);
        assertFalse(resultadoPiernas);

        assertEquals(0, alien.getNumeroPiernas());
    }




}