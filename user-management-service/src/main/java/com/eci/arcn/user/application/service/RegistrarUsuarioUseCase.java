package com.eci.arcn.user.application.service;

import com.eci.arcn.user.application.command.RegistrarUsuarioCommand;
import com.eci.arcn.user.domain.model.Usuario;
import com.eci.arcn.user.domain.repository.UsuarioRepository;

/**
 * Use case for registering a new user in the system.
 * This class handles the logic for validating and creating a new user, 
 * ensuring that the email is not already registered and simulating password encryption.
 */
public class RegistrarUsuarioUseCase {

    private final UsuarioRepository repository;

    /**
     * Constructor for the use case.
     * 
     * @param repository The repository used to manage user persistence.
     */
    public RegistrarUsuarioUseCase(UsuarioRepository repository) {
        this.repository = repository;
    }

    /**
     * Executes the user registration process.
     * 
     * Steps:
     * 1. Validates that the email is not already registered.
     * 2. Simulates password encryption.
     * 3. Creates and saves the new user in the repository.
     * 
     * @param command The command containing the user's email and password.
     * @return The newly created user.
     * @throws IllegalArgumentException If the email is already registered.
     */
    public Usuario ejecutar(RegistrarUsuarioCommand command) {
        if (repository.buscarPorEmail(command.getEmail()).isPresent()) {
            throw new IllegalArgumentException("El email ya está registrado");
        }

        // Simulates encryption (should be replaced with a real external service)
        String hash = "**" + command.getPassword() + "**";

        Usuario nuevoUsuario = new Usuario(command.getEmail(), hash);
        repository.guardar(nuevoUsuario);
        return nuevoUsuario;
    }
}


