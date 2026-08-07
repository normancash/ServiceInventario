package org.uam.serviceinventario.dto;

public record MunicipioDTO(
    String id,
    String nombre,
    String descripcion,
    String idDepartamento,
    String nombreDepartamento
) {}
