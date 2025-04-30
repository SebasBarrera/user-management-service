/**
 * Command class for user registration.
 * Encapsulates email and password details.
 */
package com.eci.arcn.user.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegistrarUsuarioCommand {
    /**
     * Email of the user to be registered.
     */
    private String email;

    /**
     * Password of the user to be registered.
     */
    private String password;
}
