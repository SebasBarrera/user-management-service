package com.eci.arcn.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.eci.arcn.user.application.service.RegistrarUsuarioUseCase;
import com.eci.arcn.user.domain.repository.UsuarioRepository;
import com.eci.arcn.user.infrastructure.controller.UsuarioController;

/**
 * Main application class for the User Management Service.
 * Configures the application context and defines beans for dependency injection.
 */
@SpringBootApplication
public class UserManagementApplication {

    /**
     * Entry point for the Spring Boot application.
     * 
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(UserManagementApplication.class, args);
    }

    /**
     * Creates a bean for the in-memory user repository.
     * 
     * @return An instance of {@link InMemoryUsuarioRepository}.
     */
    @Bean
    public UsuarioRepository usuarioRepository() {
        return new InMemoryUsuarioRepository();
    }

    /**
     * Creates a bean for the use case to register users.
     * 
     * @param repository The user repository to be used by the use case.
     * @return An instance of {@link RegistrarUsuarioUseCase}.
     */
    @Bean
    public RegistrarUsuarioUseCase registrarUsuarioUseCase(UsuarioRepository repository) {
        return new RegistrarUsuarioUseCase(repository);
    }

    /**
     * Creates a bean for the user controller.
     * 
     * @param useCase The use case to be used by the controller.
     * @return An instance of {@link UsuarioController}.
     */
    @Bean
    public UsuarioController usuarioController(RegistrarUsuarioUseCase useCase) {
        return new UsuarioController(useCase);
    }
}
