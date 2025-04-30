package com.eci.arcn.user.domain.model;

import lombok.Value;

/**
 * Represents an address with street, city, postal code, and country.
 * This class is immutable and uses Lombok's {@code @Value} annotation.
 */
@Value
public class Direccion {
    /**
     * Street of the address.
     */
    String calle;

    /**
     * City of the address.
     */
    String ciudad;

    /**
     * Postal code of the address.
     */
    String codigoPostal;

    /**
     * Country of the address.
     */
    String pais;

    /**
     * Constructor for the Direccion class.
     * 
     * @param calle        The street of the address. Cannot be null.
     * @param ciudad       The city of the address. Cannot be null.
     * @param codigoPostal The postal code of the address. Cannot be null.
     * @param pais         The country of the address. Cannot be null.
     * @throws IllegalArgumentException If any of the fields are null.
     */
    public Direccion(String calle, String ciudad, String codigoPostal, String pais) {
        if (calle == null || ciudad == null || codigoPostal == null || pais == null) {
            throw new IllegalArgumentException("Todos los campos de la dirección son obligatorios.");
        }
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
    }
}
