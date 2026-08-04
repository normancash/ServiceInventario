package org.uam.serviceinventario.dto;

import java.util.UUID;

public record PersonaDTO(
        UUID id,
        String nombre,
        String apellido,
        String correo
) {
}

//ENTIDAD, LISTAS.
//INSERT,UPDATE,DELETE,SELECT
//CONVERTIRDTO(ENTIDAD)
//CONVERTIRENTIDAD(DTO)
