package com.krakedev.aliens.testJUnit;

import com.krakedev.aliens.Alien;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestConstructoresJUnit {

    //TEST ASIGNACION DE ATRIBUTOS
    @Test
    public void testAtributos() {
        Alien alien = new Alien(10, "Verde");

        assertEquals(10, alien.getTamanio());
        assertEquals("Verde", alien.getColor());

    }

    //TEST RECTRICCION DE TAMAÑO
    @Test
    public void testTamanioMenorA5() {
        Alien alien = new Alien(2, "Verde");
        assertEquals(5, alien.getTamanio());
    }
    @Test
    public void testColorMayorA30() {
        Alien alien = new Alien(50, "Verde");
        assertEquals(30, alien.getTamanio());
    }

    //TEST CALCULO DE PRECIOS

    @Test
    public void testPrecios() {
        Alien alien = new Alien(10, "Verde");
        assertEquals(1.0, alien.getPrecioExtremidades());
        assertEquals(0.5, alien.getPrecioOjo());
        assertEquals(2, alien.getPrecioCuerpo());
    }



}