package com.eci.arcn.user.infrastructure.persistence;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.eci.arcn.user.domain.model.Usuario;
import com.eci.arcn.user.infrastructure.Persistence.InMemoryUsuarioRepository;

public class InMemoryUsuarioRepositoryTest {

    /**
     * Tests saving and retrieving a user by email.
     * 
     * This test verifies that:
     * - A user can be saved in the in-memory repository.
     * - The user can be retrieved by their email.
     * - The retrieved user's email matches the expected value.
     */
    @Test
    void guardaYRecuperaUsuarioPorEmail() {
        InMemoryUsuarioRepository repo = new InMemoryUsuarioRepository();
        Usuario usuario = new Usuario("test@correo.com", "claveSegura123");
        repo.guardar(usuario);

        Optional<Usuario> recuperado = repo.buscarPorEmail("test@correo.com");

        assertTrue(recuperado.isPresent());
        assertEquals("test@correo.com", recuperado.get().getEmail());
    }
}
