package com.krakedev.aliens.testJUnit;

import com.krakedev.aliens.Alien;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestCalcularPrecioTotal {

    @Test
    void testCalculoPrecioInicial() {
        Alien alien = new Alien(10, "Verde");
        // Para tamaño 10: Cuerpo = 10 * 0.2 = 2.0
        // Sin brazos, piernas ni ojos -> Precio Total debe ser 2.0
        assertEquals(2.0, alien.getPrecioTotal());
    }

    @Test
    void testAgregarBrazosYPiernasActualizaPrecio() {
        Alien alien = new Alien(10, "Verde");
        // Extremidad unitaria = 10 * 0.1 = 1.0

        assertTrue(alien.agregarBrazos(2)); // +2.0
        assertEquals(4.0, alien.getPrecioTotal()); // Cuerpo(2.0) + Brazos(2.0) = 4.0

        assertTrue(alien.agregarPiernas(3)); // +3.0
        assertEquals(7.0, alien.getPrecioTotal()); // Cuerpo(2.0) + Extremidades(5.0) = 7.0
    }

    @Test
    void testAgregarOjosSegunTamanioYActualizaPrecio() {
        Alien alien = new Alien(10, "Verde");
        // Ojo unitario = 10 * 0.05 = 0.5

        assertTrue(alien.agregarOjos(3)); // Válido para tamaño <= 10
        assertEquals(3.5, alien.getPrecioTotal()); // Cuerpo(2.0) + Ojos(1.5) = 3.5

        // Si falla la validación (4 ojos excede el límite de 3), los ojos vuelven a 0 y el precio se recalcula
        assertFalse(alien.agregarOjos(4));
        assertEquals(0, alien.getNumeroOjos());
        assertEquals(2.0, alien.getPrecioTotal()); // Vuelve al precio base
    }

    @Test
    void testExcederLimiteExtremidadesResetaPrecio() {
        Alien alien = new Alien(10, "Verde");

        assertTrue(alien.agregarBrazos(6));
        assertEquals(8.0, alien.getPrecioTotal()); // Cuerpo(2.0) + Brazos(6.0) = 8.0

        // Intentar agregar 5 piernas sumaría 11 extremidades (> 10 max).
        assertFalse(alien.agregarPiernas(5));
        assertEquals(0, alien.getNumeroPiernas());
        assertEquals(8.0, alien.getPrecioTotal()); // Mantiene el cobro de los 6 brazos
    }
}