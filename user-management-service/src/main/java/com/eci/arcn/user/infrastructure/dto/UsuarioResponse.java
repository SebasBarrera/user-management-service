package com.eci.arcn.user.infrastructure.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO (Data Transfer Object) for user responses.
 * Encapsulates the user's ID and email to be returned to the client.
 */
@Data
@AllArgsConstructor
public class UsuarioResponse {

    /**
     * The unique identifier of the user.
     */
    private UUID id;

    /**
     * The email of the user.
     */
    private String email;
}
