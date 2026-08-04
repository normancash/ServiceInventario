package org.uam.serviceinventario.dto;

public record CategoriaDTO(
        GenericoDTO generic,
        String nombre,
        String descripcion
) {
}
