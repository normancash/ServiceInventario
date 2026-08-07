package org.uam.serviceinventario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.uam.serviceinventario.dto.MunicipioDTO;
import org.uam.serviceinventario.model.Municipio;

@Mapper(componentModel = "spring")
public interface MunicipioMapper {

    @Mappings({
            @Mapping(target = "idDepartamento",source = "departamento.id"),
            @Mapping(target="nombreDepartamento",source = "departamento.nombre")
    })
    MunicipioDTO toDTO(Municipio municipio);

    @Mapping(target = "departamento",ignore = true)
    Municipio toEntity(MunicipioDTO municipioDTO);

}
