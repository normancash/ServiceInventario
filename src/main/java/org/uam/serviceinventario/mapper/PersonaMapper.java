package org.uam.serviceinventario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.uam.serviceinventario.dto.PersonaDTO;
import org.uam.serviceinventario.model.Persona;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaMapper {

    @Mapping(target="correo",source="email")
    PersonaDTO toDTO(Persona persona);

    @Mapping(target="email",source="correo")
    Persona toEntity(PersonaDTO personaDTO);

    @Mapping(target="correo",source="email")
    List<PersonaDTO> toListDTO(List<Persona> personas);

    //buscar por id.
    //entidad.
    //actualiza cada campo
    @Mappings(
            { @Mapping(target="id",ignore=true),
              @Mapping(target="email",source="correo")})
    void update(PersonaDTO dto, @MappingTarget Persona persona);
}
