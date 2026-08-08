package org.uam.serviceinventario.mapper;

import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.uam.serviceinventario.dto.DepartamentoDTO;
import org.uam.serviceinventario.model.Departamento;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-07T20:21:11-0600",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class DepartamentoMapperImpl implements DepartamentoMapper {

    @Override
    public DepartamentoDTO toDto(Departamento departamento) {
        if ( departamento == null ) {
            return null;
        }

        UUID id = null;
        String nombre = null;
        String descripcion = null;

        id = departamento.getId();
        nombre = departamento.getNombre();
        descripcion = departamento.getDescripcion();

        DepartamentoDTO departamentoDTO = new DepartamentoDTO( id, nombre, descripcion );

        return departamentoDTO;
    }

    @Override
    public Departamento toEntity(DepartamentoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Departamento departamento = new Departamento();

        departamento.setId( dto.id() );
        departamento.setNombre( dto.nombre() );
        departamento.setDescripcion( dto.descripcion() );

        return departamento;
    }
}
