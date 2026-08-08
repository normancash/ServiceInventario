package org.uam.serviceinventario.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ProductoDTO(
     GenericoDTO generic,
     String nombre,
     String descripcion,
     UUID idCategoria
) {
}
