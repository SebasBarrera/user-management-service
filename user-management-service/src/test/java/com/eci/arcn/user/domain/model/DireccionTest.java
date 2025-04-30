package com.eci.arcn.user.domain.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DireccionTest {

    /**
     * Tests the creation of a valid Direccion object.
     * 
     * This test verifies that:
     * - A Direccion object is created successfully when all fields are valid.
     * - The getter methods return the correct values for each field.
     */
    @Test
    public void direccionValida_creaObjetoCorrectamente() {
        Direccion direccion = new Direccion("Calle 123", "Bogotá", "110111", "Colombia");

        assertEquals("Calle 123", direccion.getCalle());
        assertEquals("Bogotá", direccion.getCiudad());
        assertEquals("110111", direccion.getCodigoPostal());
        assertEquals("Colombia", direccion.getPais());
    }

    /**
     * Tests the creation of an invalid Direccion object.
     * 
     * This test verifies that:
     * - An exception is thrown when any of the fields (street, city, postal code, or country) is null.
     * - The exception is of type {@link IllegalArgumentException}.
     */
    @Test
    public void direccionInvalida_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Direccion(null, "Bogotá", "110111", "Colombia");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Direccion("Calle 123", null, "110111", "Colombia");
        });
    }
}
