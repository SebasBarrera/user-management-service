package com.eci.arcn.user.domain.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UsuarioTest {

    /**
     * Tests the creation of a valid Usuario object.
     * 
     * This test verifies that:
     * - A Usuario object is created successfully when the email and password are valid.
     * - The email, user ID, and password hash are correctly set.
     * - The list of addresses is initially empty.
     */
    @Test
    public void usuarioValido_seCreaCorrectamente() {
        Usuario usuario = new Usuario("correo@ejemplo.com", "passwordSeguro");

        assertEquals("correo@ejemplo.com", usuario.getEmail());
        assertNotNull(usuario.getUserId());
        assertEquals("passwordSeguro", usuario.getPasswordHash());
        assertTrue(usuario.getDirecciones().isEmpty());
    }

    /**
     * Tests the creation of a Usuario object with an invalid email.
     * 
     * This test verifies that:
     * - An exception is thrown when the email does not contain the "@" symbol.
     * - The exception is of type {@link IllegalArgumentException}.
     */
    @Test
    public void emailInvalido_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("correoSinArroba", "clave1234");
        });
    }

    /**
     * Tests the creation of a Usuario object with an invalid password.
     * 
     * This test verifies that:
     * - An exception is thrown when the password is null or has fewer than 8 characters.
     * - The exception is of type {@link IllegalArgumentException}.
     */
    @Test
    public void contrasenaInvalida_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("correo@ejemplo.com", "123");
        });
    }

    /**
     * Tests adding a valid address to a Usuario object.
     * 
     * This test verifies that:
     * - A valid address can be added to the user's list of addresses.
     * - The list of addresses contains the added address.
     * - The fields of the added address are correctly set.
     */
    @Test
    public void agregarDireccionValida_funcionaCorrectamente() {
        Usuario usuario = new Usuario("correo@ejemplo.com", "claveSegura");
        Direccion direccion = new Direccion("Calle 1", "Bogotá", "110111", "Colombia");

        usuario.agregarDireccion(direccion);

        assertEquals(1, usuario.getDirecciones().size());
        assertEquals("Bogotá", usuario.getDirecciones().get(0).getCiudad());
    }

    /**
     * Tests adding a null address to a Usuario object.
     * 
     * This test verifies that:
     * - An exception is thrown when trying to add a null address.
     * - The exception is of type {@link IllegalArgumentException}.
     */
    @Test
    public void agregarDireccionNula_lanzaExcepcion() {
        Usuario usuario = new Usuario("correo@ejemplo.com", "claveSegura");

        assertThrows(IllegalArgumentException.class, () -> {
            usuario.agregarDireccion(null);
        });
    }
}
