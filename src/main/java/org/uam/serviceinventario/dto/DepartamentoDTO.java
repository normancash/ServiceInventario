package org.uam.serviceinventario.dto;

import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

public record DepartamentoDTO(
     UUID id,
     String nombre,
     String descripcion
) {
}
