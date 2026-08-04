package org.uam.serviceinventario.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.uam.serviceinventario.dto.PersonaDTO;
import org.uam.serviceinventario.model.Persona;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-03T20:37:19-0600",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class PersonaMapperImpl implements PersonaMapper {

    @Override
    public PersonaDTO toDTO(Persona persona) {
        if ( persona == null ) {
            return null;
        }

        String correo = null;
        UUID id = null;
        String nombre = null;
        String apellido = null;

        correo = persona.getEmail();
        id = persona.getId();
        nombre = persona.getNombre();
        apellido = persona.getApellido();

        PersonaDTO personaDTO = new PersonaDTO( id, nombre, apellido, correo );

        return personaDTO;
    }

    @Override
    public Persona toEntity(PersonaDTO personaDTO) {
        if ( personaDTO == null ) {
            return null;
        }

        Persona persona = new Persona();

        persona.setEmail( personaDTO.correo() );
        persona.setId( personaDTO.id() );
        persona.setNombre( personaDTO.nombre() );
        persona.setApellido( personaDTO.apellido() );

        return persona;
    }

    @Override
    public List<PersonaDTO> toListDTO(List<Persona> personas) {
        if ( personas == null ) {
            return null;
        }

        List<PersonaDTO> list = new ArrayList<PersonaDTO>( personas.size() );
        for ( Persona persona : personas ) {
            list.add( toDTO( persona ) );
        }

        return list;
    }

    @Override
    public void update(PersonaDTO dto, Persona persona) {
        if ( dto == null ) {
            return;
        }

        persona.setEmail( dto.correo() );
        persona.setNombre( dto.nombre() );
        persona.setApellido( dto.apellido() );
    }
}
