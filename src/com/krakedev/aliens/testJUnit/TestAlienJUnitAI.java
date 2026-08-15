package com.krakedev.aliens.testJUnit;
import org.junit.jupiter.api.Test;
import com.krakedev.aliens.Alien;

import static org.junit.jupiter.api.Assertions.*;

class TestAlienJUnitAI {

    // Margen de tolerancia para comparaciones entre números decimales (double)
    private static final double DELTA = 0.001;

    // ==========================================
    // PRUEBAS PARA: agregarBrazos(int)
    // ==========================================

    @Test
    void testAgregarBrazosValido() {
        // Valida que al agregar un número válido de brazos (dentro del límite de 10)
        // retorne true, actualice el atributo y calcule el precio total adecuadamente.
        Alien alien = new Alien(10, "Verde"); // cuerpo = 2.0, ext = 1.0/ud

        boolean resultado = alien.agregarBrazos(4);

        assertTrue(resultado);
        assertEquals(4, alien.getNumeroBrazos());
        // Precio: Cuerpo (2.0) + 4 brazos * 1.0 = 6.0
        assertEquals(6.0, alien.getPrecioTotal(), DELTA);
    }

    @Test
    void testAgregarBrazosExcedeLimite() {
        // Valida que al intentar agregar más de 10 brazos, el método retorne false,
        // reinicie numeroBrazos a 0 y recalcule el precio total sin contar brazos.
        Alien alien = new Alien(10, "Verde");

        boolean resultado = alien.agregarBrazos(11);

        assertFalse(resultado);
        assertEquals(0, alien.getNumeroBrazos());
        // Precio: Solo cuerpo (2.0)
        assertEquals(2.0, alien.getPrecioTotal(), DELTA);
    }

    // ==========================================
    // PRUEBAS PARA: agregarPiernas(int)
    // ==========================================

    @Test
    void testAgregarPiernasValidoConBrazosExistentes() {
        // Valida que se puedan agregar piernas siempre que la suma de (brazos + piernas) <= 10.
        Alien alien = new Alien(10, "Gris"); // cuerpo = 2.0, ext = 1.0/ud
        alien.agregarBrazos(3);

        boolean resultado = alien.agregarPiernas(5); // Suma total = 8 (válido)

        assertTrue(resultado);
        assertEquals(5, alien.getNumeroPiernas());
        // Precio: Cuerpo (2.0) + (3 brazos + 5 piernas) * 1.0 = 10.0
        assertEquals(10.0, alien.getPrecioTotal(), DELTA);
    }

    @Test
    void testAgregarPiernasExcedeLimiteCombinado() {
        // Valida que si la suma de brazos previa y piernas nuevas supera 10,
        // el método retorne false, las piernas se reinicien a 0 y el precio no incluya piernas.
        Alien alien = new Alien(10, "Gris");
        alien.agregarBrazos(6); // 6 brazos registrados correctamente

        boolean resultado = alien.agregarPiernas(5); // 6 + 5 = 11 (> 10 límite)

        assertFalse(resultado);
        assertEquals(0, alien.getNumeroPiernas());
        // Precio: Cuerpo (2.0) + 6 brazos * 1.0 = 8.0
        assertEquals(8.0, alien.getPrecioTotal(), DELTA);
    }

    // ==========================================
    // PRUEBAS PARA: agregarOjos(int)
    // ==========================================

    @Test
    void testAgregarOjosTamanioPequenio() {
        // Para tamaño entre 5 y 10 cm, el máximo es 3 ojos.
        // Se valida el límite superior válido (3) y la actualización del precio.
        Alien alien = new Alien(8, "Rojo"); // cuerpo = 1.6, ojo = 0.4/ud

        boolean resultado = alien.agregarOjos(3);

        assertTrue(resultado);
        assertEquals(3, alien.getNumeroOjos());
        // Precio: Cuerpo (1.6) + 3 ojos * 0.4 = 2.8
        assertEquals(2.8, alien.getPrecioTotal(), DELTA);
    }

    @Test
    void testAgregarOjosTamanioMedianoExcedido() {
        // Para tamaño entre 11 y 20 cm, el máximo es 5 ojos.
        // Se valida que al intentar colocar 6 ojos retorne false,
        // el numeroOjos se reinicie a 0 y se recalcule el precio a solo el cuerpo.
        Alien alien = new Alien(15, "Azul"); // cuerpo = 3.0, ojo = 0.75/ud

        boolean resultado = alien.agregarOjos(6);

        assertFalse(resultado);
        assertEquals(0, alien.getNumeroOjos());
        // Precio: Solo cuerpo (3.0)
        assertEquals(3.0, alien.getPrecioTotal(), DELTA);
    }

    @Test
    void testAgregarOjosTamanioGrandeValido() {
        // Para tamaño entre 21 y 30 cm, el máximo es 7 ojos.
        // Se valida la asignación correcta dentro del rango permitido.
        Alien alien = new Alien(25, "Morado"); // cuerpo = 5.0, ojo = 1.25/ud

        boolean resultado = alien.agregarOjos(7);

        assertTrue(resultado);
        assertEquals(7, alien.getNumeroOjos());
        // Precio: Cuerpo (5.0) + 7 ojos * 1.25 = 13.75
        assertEquals(13.75, alien.getPrecioTotal(), DELTA);
    }

    // ==========================================
    // PRUEBAS PARA: calcularPrecioTotal()
    // ==========================================

    @Test
    void testCalcularPrecioTotalCompleto() {
        // Valida la integración de la fórmula completa de precioTotal sumando:
        // Cuerpo + (Extremidades combinadas * precioExtremidades) + (Ojos * precioOjo).
        Alien alien = new Alien(20, "Negro");
        // Precios calculados internamente para tamaño 20:
        // precioCuerpo = 0.2 * 20 = 4.0
        // precioExtremidades = 0.1 * 20 = 2.0
        // precioOjo = 0.05 * 20 = 1.0

        alien.agregarBrazos(2);
        alien.agregarPiernas(2);
        alien.agregarOjos(4); // Para tamaño 20, máx 5 ojos

        // Ejecutamos explícitamente el método calcularPrecioTotal()
        alien.calcularPrecioTotal();

        // Esperado: 4.0 (cuerpo) + (4 extremidades * 2.0) + (4 ojos * 1.0) = 16.0
        assertEquals(16.0, alien.getPrecioTotal(), DELTA);
    }

    @Test
    void testCalcularPrecioTotalDespuesDeFalloEnOjos() {
        // Valida que si un alien ya tenía ojos y luego falla un nuevo intento de agregarOjos,
        // al reiniciarse los ojos a 0 el método calcularPrecioTotal() actualiza la cuenta sin los ojos.
        Alien alien = new Alien(10, "Amarillo"); // cuerpo = 2.0, ojo = 0.5/ud

        alien.agregarOjos(2); // Precio acumulado: 2.0 + (2 * 0.5) = 3.0
        assertEquals(3.0, alien.getPrecioTotal(), DELTA);

        // Intento con valor inválido para tamaño 10 (máx 3 ojos)
        alien.agregarOjos(5); // Falla y resetea numeroOjos a 0

        // El precio debe actualizarse y descontar los ojos
        assertEquals(0, alien.getNumeroOjos());
        assertEquals(2.0, alien.getPrecioTotal(), DELTA);
    }
}


//PROMPT IA
/*
Desde la clase Alien que te acabo de compartir quiero que generes una clase de pruebas unitarias con JUnit 5 para los metodos:

public boolean agregarBrazos (int numeroBrazos)
public boolean agregarPiernas (int numeroPiernas)
public boolean agregarOjos (int numeroOjos)
public void calcularPrecioTotal()

REQUISITOS:

        - usa solo el constructor de la clase

- construye todos los casos de prueba importantes

- incluye comentarios explicando que valida cada caso

- usa unicamente los constructores, getters y metodos realmente disponibles en la clase

- no inventes metodos que no existen

- usa assertEquals, assertTrue, assertFalse y usa una tolerancia en los assertscuando corresponda

- nombra la clase de prueba como TestAlienJUnitAI*/
