package org.uam.serviceinventario.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record AdministradorDTO(
        UUID uuid,
        String nombre,
        String apellido,
        String email,
        String cedula,
        String areaAdministrativa
) {
}
