package org.uam.serviceinventario.mapper;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.uam.serviceinventario.dto.GenericoDTO;
import org.uam.serviceinventario.model.BaseEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-03T20:11:32-0600",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class GenericFieldMapperImpl implements GenericFieldMapper {

    @Override
    public GenericoDTO toGenericDTO(BaseEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID uuid = null;
        String usuarioIns = null;
        String usuarioUpd = null;
        LocalDateTime fechaIns = null;
        LocalDateTime fechaUpd = null;

        if ( entity.getUuid() != null ) {
            uuid = entity.getUuid();
        }
        if ( entity.getUsuarioIns() != null ) {
            usuarioIns = entity.getUsuarioIns();
        }
        if ( entity.getUsuarioUpd() != null ) {
            usuarioUpd = entity.getUsuarioUpd();
        }
        if ( entity.getFechaIns() != null ) {
            fechaIns = entity.getFechaIns();
        }
        if ( entity.getFechaUpd() != null ) {
            fechaUpd = entity.getFechaUpd();
        }

        GenericoDTO genericoDTO = new GenericoDTO( uuid, usuarioIns, usuarioUpd, fechaIns, fechaUpd );

        return genericoDTO;
    }

    @Override
    public void updateEntityFromGenericDTO(GenericoDTO dto, BaseEntity entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.uuid() != null ) {
            entity.setUuid( dto.uuid() );
        }
        else {
            entity.setUuid( null );
        }
        if ( dto.fechaIns() != null ) {
            entity.setFechaIns( dto.fechaIns() );
        }
        else {
            entity.setFechaIns( null );
        }
        if ( dto.fechaUpd() != null ) {
            entity.setFechaUpd( dto.fechaUpd() );
        }
        else {
            entity.setFechaUpd( null );
        }
        if ( dto.usuarioIns() != null ) {
            entity.setUsuarioIns( dto.usuarioIns() );
        }
        else {
            entity.setUsuarioIns( null );
        }
        if ( dto.usuarioUpd() != null ) {
            entity.setUsuarioUpd( dto.usuarioUpd() );
        }
        else {
            entity.setUsuarioUpd( null );
        }
    }
}
