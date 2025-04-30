package com.eci.arcn.user.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eci.arcn.user.application.command.RegistrarUsuarioCommand;
import com.eci.arcn.user.application.service.RegistrarUsuarioUseCase;
import com.eci.arcn.user.domain.model.Usuario;
import com.eci.arcn.user.infrastructure.dto.RegistroUsuarioRequest;
import com.eci.arcn.user.infrastructure.dto.UsuarioResponse;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final RegistrarUsuarioUseCase useCase;

    /**
     * Constructor for the UsuarioController class.
     * 
     * @param useCase The use case for registering a user. Must not be null.
     */
    public UsuarioController(RegistrarUsuarioUseCase useCase) {
        this.useCase = useCase;
    }

    /**
     * Handles the HTTP POST request to register a new user.
     * 
     * Endpoint: {@code /api/usuarios/registrar}
     * 
     * Steps:
     * 1. Converts the incoming request into a command object.
     * 2. Executes the use case to register the user.
     * 3. Returns a response containing the registered user's details.
     * 
     * @param request The request body containing the user's email and password.
     * @return A {@code ResponseEntity} containing the user's ID and email.
     */
    @PostMapping("/registrar")
    public ResponseEntity<UsuarioResponse> registrar(@RequestBody RegistroUsuarioRequest request) {
        RegistrarUsuarioCommand command = new RegistrarUsuarioCommand(
                request.getEmail(), request.getPassword()
        );

        Usuario usuario = useCase.ejecutar(command);
        return ResponseEntity.ok(new UsuarioResponse(usuario.getUserId(), usuario.getEmail()));
    }
}
