package com.krakedev.aliens.testJUnit;

import com.krakedev.aliens.Alien;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TestConstructoresAI {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    // Redirigir la salida estándar (System.out) antes de cada prueba para capturar las impresiones en consola
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    // Restablecer la salida estándar original de la consola después de cada prueba
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    // 1. Valida un tamaño dentro del rango permitido (entre 5 y 30) y el cálculo correcto de precios
    @Test
    void testConstructorTamanioValido() {
        Alien alien = new Alien(10, "Verde");

        // Verifica que el tamaño y color asignados sean los correctos
        assertEquals(10, alien.getTamanio());
        assertEquals("Verde", alien.getColor());

        // Verifica los cálculos de precios según la especificación:
        // Cuerpo: 20% de 10 = 2.0
        // Extremidades: 10% de 10 = 1.0
        // Ojos: 5% de 10 = 0.5
        assertEquals(2.0, alien.getPrecioCuerpo());
        assertEquals(1.0, alien.getPrecioExtremidades());
        assertEquals(0.5, alien.getPrecioOjo());
    }

    // 2. Valida la frontera inferior (Límite Mínimo exacto = 5)
    @Test
    void testConstructorTamanioLimiteMinimo() {
        Alien alien = new Alien(5, "Azul");

        // El tamaño 5 es válido y no debe modificarse
        assertEquals(5, alien.getTamanio());

        // Precios calculados con tamaño 5:
        assertEquals(1.0, alien.getPrecioCuerpo());
        assertEquals(0.5, alien.getPrecioExtremidades());
        assertEquals(0.25, alien.getPrecioOjo());
    }

    // 3. Valida la frontera superior (Límite Máximo exacto = 30)
    @Test
    void testConstructorTamanioLimiteMaximo() {
        Alien alien = new Alien(30, "Rojo");

        // El tamaño 30 es válido y no debe modificarse
        assertEquals(30, alien.getTamanio());

        // Precios calculados con tamaño 30:
        assertEquals(6.0, alien.getPrecioCuerpo());
        assertEquals(3.0, alien.getPrecioExtremidades());
        assertEquals(1.5, alien.getPrecioOjo());
    }

    // 4. Valida el ajuste automático de tamaño si es inferior al mínimo permititdo (menor a 5)
    @Test
    void testConstructorTamanioMenorAlMinimo() {
        Alien alien = new Alien(2, "Amarillo");

        // Se debe ajustar automáticamente al valor mínimo de 5
        assertEquals(5, alien.getTamanio());

        // Los precios se deben recalcular con el tamaño ajustado de 5
        assertEquals(1.0, alien.getPrecioCuerpo());
        assertEquals(0.5, alien.getPrecioExtremidades());
        assertEquals(0.25, alien.getPrecioOjo());
    }

    // 5. Valida el ajuste automático de tamaño si es superior al máximo permitido (mayor a 30)
    @Test
    void testConstructorTamanioMayorAlMaximo() {
        Alien alien = new Alien(50, "Púrpura");

        // Se debe ajustar automáticamente al valor máximo de 30
        assertEquals(30, alien.getTamanio());

        // Los precios se deben recalcular con el tamaño ajustado de 30
        assertEquals(6.0, alien.getPrecioCuerpo());
        assertEquals(3.0, alien.getPrecioExtremidades());
        assertEquals(1.5, alien.getPrecioOjo());
    }

    // 6. Valida la ejecución del método imprimir() y que muestre el mensaje esperado
    @Test
    void testMetodoImprimir() {
        Alien alien = new Alien(10, "Gris");

        // Limpiamos el buffer para omitir el System.out.println emitido dentro del constructor
        outputStreamCaptor.reset();

        // Ejecución del método a probar
        alien.imprimir();

        // Construcción del mensaje esperado según la firma y valores de los atributos
        String mensajeEsperado = "Tamaño: 10" +
                "\nColor: Gris" +
                "\nOjos: 0" +
                "\nBrazos: 0" +
                "\nPies: 0" +
                "\nPrecio Extremidades: $1.0" +
                "\nPrecio Ojos: $0.5" +
                "\nPrecio Cuerpo: $2.0";

        // Se valida que la salida capturada de la consola sea igual al mensaje esperado (limpiando espacios/saltos finales)
        assertEquals(mensajeEsperado, outputStreamCaptor.toString().trim());
    }
}


//PROMPT IA
/*
Te voy a compartir la clase Java llamada Alien.

Quiero que generes una clase de pruebas unitarias con JUnit 5 para el constructor y el metodo imprimir:


IMPORTANTE:

No construyas la prueba basandote en el codigo interno del método.
Construye los casos de prueba basandote en esta descripcion funcional:
        - el metodo imprimir recibe todos los atributos y los muestra con un System.out.println(mensaje)

- el constructor recibe el tamaño y el color

- se verifica el tamaño, el tamaño minimo es 5 y eñ tamaño maximo es 30 si el valor está fuera del rango, ajustarlo automáticamente.

        - los precios se calculan en base a lo siguiente:
Precio del cuerpo: 20% del tamaño
Precio de extremidades: 10% del tamaño
Precio de ojos: 5% del tamaño


REQUISITOS:

        - construye todos los casos de prueba importantes

- incluye comentarios explicando que valida cada caso

- usa unicamente los constructores, getters y metodos realmente disponibles en la clase

- no inventes metodos que no existen

- usa assertEquals cuando corresponda

- nombra la clase de prueba como TestConstructoresAI



Aqui esta la clase Alien:*/
