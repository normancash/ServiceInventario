package org.uam.serviceinventario.mapper;

import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.uam.serviceinventario.dto.MunicipioDTO;
import org.uam.serviceinventario.model.Departamento;
import org.uam.serviceinventario.model.Municipio;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-07T20:21:10-0600",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class MunicipioMapperImpl implements MunicipioMapper {

    @Override
    public MunicipioDTO toDTO(Municipio municipio) {
        if ( municipio == null ) {
            return null;
        }

        String idDepartamento = null;
        String nombreDepartamento = null;
        String id = null;
        String nombre = null;
        String descripcion = null;

        UUID id1 = municipioDepartamentoId( municipio );
        if ( id1 != null ) {
            idDepartamento = id1.toString();
        }
        nombreDepartamento = municipioDepartamentoNombre( municipio );
        if ( municipio.getId() != null ) {
            id = municipio.getId().toString();
        }
        nombre = municipio.getNombre();
        descripcion = municipio.getDescripcion();

        MunicipioDTO municipioDTO = new MunicipioDTO( id, nombre, descripcion, idDepartamento, nombreDepartamento );

        return municipioDTO;
    }

    @Override
    public Municipio toEntity(MunicipioDTO municipioDTO) {
        if ( municipioDTO == null ) {
            return null;
        }

        Municipio municipio = new Municipio();

        if ( municipioDTO.id() != null ) {
            municipio.setId( UUID.fromString( municipioDTO.id() ) );
        }
        municipio.setNombre( municipioDTO.nombre() );
        municipio.setDescripcion( municipioDTO.descripcion() );

        return municipio;
    }

    private UUID municipioDepartamentoId(Municipio municipio) {
        Departamento departamento = municipio.getDepartamento();
        if ( departamento == null ) {
            return null;
        }
        return departamento.getId();
    }

    private String municipioDepartamentoNombre(Municipio municipio) {
        Departamento departamento = municipio.getDepartamento();
        if ( departamento == null ) {
            return null;
        }
        return departamento.getNombre();
    }
}
