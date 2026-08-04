package org.uam.serviceinventario.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record GenericoDTO(
    UUID uuid,
    String usuarioIns,
    String usuarioUpd,
    LocalDateTime fechaIns,
    LocalDateTime fechaUpd
) {
}
