package com.eci.arcn.user.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;

@Getter
public class Usuario {
    private final UUID userId;
    private final String email;
    private final String passwordHash;
    private final List<Direccion> direcciones;

    /**
     * Constructor for the Usuario class.
     * 
     * @param email        The email of the user. Must contain "@".
     * @param passwordHash The hashed password of the user. Must not be null and must have at least 8 characters.
     * @throws IllegalArgumentException If the email is invalid or the password is insecure.
     */
    public Usuario(String email, String passwordHash) {
        if (!email.contains("@")) throw new IllegalArgumentException("Email inválido");
        if (passwordHash == null || passwordHash.length() < 8)
            throw new IllegalArgumentException("Contraseña insegura");

        this.userId = UUID.randomUUID();
        this.email = email;
        this.passwordHash = passwordHash;
        this.direcciones = new ArrayList<>();
    }

    /**
     * Adds a new address to the user's list of addresses.
     * 
     * @param direccion The address to be added. Must not be null.
     * @throws IllegalArgumentException If the address is null.
     */
    public void agregarDireccion(Direccion direccion) {
        if (direccion == null) throw new IllegalArgumentException("Dirección inválida");
        this.direcciones.add(direccion);
    }
}
