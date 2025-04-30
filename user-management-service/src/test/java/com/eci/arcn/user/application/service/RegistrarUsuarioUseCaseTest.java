package com.eci.arcn.user.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.eci.arcn.user.application.command.RegistrarUsuarioCommand;
import com.eci.arcn.user.domain.model.Usuario;
import com.eci.arcn.user.domain.repository.UsuarioRepository;

public class RegistrarUsuarioUseCaseTest {

    private UsuarioRepository repository;
    private RegistrarUsuarioUseCase useCase;

    /**
     * Sets up the test environment by mocking the repository and initializing the use case.
     */
    @BeforeEach
    public void setup() {
        repository = Mockito.mock(UsuarioRepository.class);
        useCase = new RegistrarUsuarioUseCase(repository);
    }

    /**
     * Tests the successful registration of a new user.
     * 
     * This test verifies that:
     * - A user with a valid email and password is successfully registered.
     * - The repository's `guardar` method is called to persist the user.
     * - The returned user contains the correct email.
     */
    @Test
    public void registroUsuarioValido_devuelveUsuario() {
        // Arrange
        RegistrarUsuarioCommand command = new RegistrarUsuarioCommand("nuevo@correo.com", "clave12345");
        when(repository.buscarPorEmail("nuevo@correo.com")).thenReturn(Optional.empty());

        // Act
        Usuario resultado = useCase.ejecutar(command);

        // Assert
        assertNotNull(resultado);
        assertEquals("nuevo@correo.com", resultado.getEmail());
        verify(repository).guardar(any(Usuario.class));
    }

    /**
     * Tests the registration of a user with an already registered email.
     * 
     * This test verifies that:
     * - An exception is thrown when trying to register a user with an existing email.
     * - The exception message matches the expected error message.
     * - The repository's `guardar` method is never called.
     */
    @Test
    public void registroUsuarioExistente_lanzaExcepcion() {
        // Arrange
        RegistrarUsuarioCommand command = new RegistrarUsuarioCommand("ya@existe.com", "clave12345");
        when(repository.buscarPorEmail("ya@existe.com")).thenReturn(Optional.of(mock(Usuario.class)));

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            useCase.ejecutar(command);
        });

        assertEquals("El email ya está registrado", exception.getMessage());
        verify(repository, never()).guardar(any());
    }
}
