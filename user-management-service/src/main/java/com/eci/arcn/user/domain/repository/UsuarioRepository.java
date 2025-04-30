package com.eci.arcn.user.domain.repository;

import java.util.Optional;
import java.util.UUID;

import com.eci.arcn.user.domain.model.Usuario;

public interface UsuarioRepository {

    /**
     * Saves a user to the repository.
     * 
     * @param usuario The user to be saved. Must not be null.
     */
    void guardar(Usuario usuario);

    /**
     * Searches for a user by their email.
     * 
     * @param email The email of the user to search for. Must not be null.
     * @return An {@code Optional} containing the user if found, or empty if not found.
     */
    Optional<Usuario> buscarPorEmail(String email);

    /**
     * Searches for a user by their unique ID.
     * 
     * @param userId The unique ID of the user to search for. Must not be null.
     * @return An {@code Optional} containing the user if found, or empty if not found.
     */
    Optional<Usuario> buscarPorId(UUID userId);
}
