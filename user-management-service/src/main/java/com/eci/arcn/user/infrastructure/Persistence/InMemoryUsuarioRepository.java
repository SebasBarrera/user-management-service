package com.eci.arcn.user.infrastructure.persistence;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.eci.arcn.user.domain.model.Usuario;
import com.eci.arcn.user.domain.repository.UsuarioRepository;

/**
 * In-memory implementation of the {@link UsuarioRepository}.
 * Stores users in memory using maps for quick access by ID and email.
 */
public class InMemoryUsuarioRepository implements UsuarioRepository {

    private final Map<UUID, Usuario> usuariosPorId = new HashMap<>();
    private final Map<String, Usuario> usuariosPorEmail = new HashMap<>();

    /**
     * Saves a user to the in-memory repository.
     * 
     * @param usuario The user to be saved. Must not be null.
     */
    @Override
    public void guardar(Usuario usuario) {
        usuariosPorId.put(usuario.getUserId(), usuario);
        usuariosPorEmail.put(usuario.getEmail(), usuario);
    }

    /**
     * Searches for a user by their email in the in-memory repository.
     * 
     * @param email The email of the user to search for. Must not be null.
     * @return An {@code Optional} containing the user if found, or empty if not found.
     */
    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        return Optional.ofNullable(usuariosPorEmail.get(email));
    }

    /**
     * Searches for a user by their unique ID in the in-memory repository.
     * 
     * @param userId The unique ID of the user to search for. Must not be null.
     * @return An {@code Optional} containing the user if found, or empty if not found.
     */
    @Override
    public Optional<Usuario> buscarPorId(UUID userId) {
        return Optional.ofNullable(usuariosPorId.get(userId));
    }
}
