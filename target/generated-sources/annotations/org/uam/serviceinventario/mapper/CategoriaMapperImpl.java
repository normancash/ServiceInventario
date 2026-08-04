package org.uam.serviceinventario.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.uam.serviceinventario.dto.CategoriaDTO;
import org.uam.serviceinventario.dto.GenericoDTO;
import org.uam.serviceinventario.model.Categoria;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-03T20:11:32-0600",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public void updateFromDTO(CategoriaDTO dto, Categoria entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.nombre() != null ) {
            entity.setNombre( dto.nombre() );
        }
        if ( dto.descripcion() != null ) {
            entity.setDescripcion( dto.descripcion() );
        }
    }

    @Override
    public List<CategoriaDTO> toDTOList(List<Categoria> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CategoriaDTO> list = new ArrayList<CategoriaDTO>( entityList.size() );
        for ( Categoria categoria : entityList ) {
            list.add( toDTO( categoria ) );
        }

        return list;
    }

    @Override
    public List<Categoria> toEntityList(List<CategoriaDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Categoria> list = new ArrayList<Categoria>( dtoList.size() );
        for ( CategoriaDTO categoriaDTO : dtoList ) {
            list.add( toEntity( categoriaDTO ) );
        }

        return list;
    }

    @Override
    public CategoriaDTO toDTO(Categoria entity) {
        if ( entity == null ) {
            return null;
        }

        GenericoDTO generic = null;
        String nombre = null;
        String descripcion = null;

        if ( entity != null ) {
            generic = categoriaToGenericoDTO( entity );
        }
        if ( entity.getNombre() != null ) {
            nombre = entity.getNombre();
        }
        if ( entity.getDescripcion() != null ) {
            descripcion = entity.getDescripcion();
        }

        CategoriaDTO categoriaDTO = new CategoriaDTO( generic, nombre, descripcion );

        return categoriaDTO;
    }

    @Override
    public Categoria toEntity(CategoriaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        UUID uuid = dtoGenericUuid( dto );
        if ( uuid != null ) {
            categoria.setUuid( uuid );
        }
        if ( dto.nombre() != null ) {
            categoria.setNombre( dto.nombre() );
        }
        if ( dto.descripcion() != null ) {
            categoria.setDescripcion( dto.descripcion() );
        }

        return categoria;
    }

    protected GenericoDTO categoriaToGenericoDTO(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        UUID uuid = null;
        String usuarioIns = null;
        String usuarioUpd = null;
        LocalDateTime fechaIns = null;
        LocalDateTime fechaUpd = null;

        if ( categoria.getUuid() != null ) {
            uuid = categoria.getUuid();
        }
        if ( categoria.getUsuarioIns() != null ) {
            usuarioIns = categoria.getUsuarioIns();
        }
        if ( categoria.getUsuarioUpd() != null ) {
            usuarioUpd = categoria.getUsuarioUpd();
        }
        if ( categoria.getFechaIns() != null ) {
            fechaIns = categoria.getFechaIns();
        }
        if ( categoria.getFechaUpd() != null ) {
            fechaUpd = categoria.getFechaUpd();
        }

        GenericoDTO genericoDTO = new GenericoDTO( uuid, usuarioIns, usuarioUpd, fechaIns, fechaUpd );

        return genericoDTO;
    }

    private UUID dtoGenericUuid(CategoriaDTO categoriaDTO) {
        GenericoDTO generic = categoriaDTO.generic();
        if ( generic == null ) {
            return null;
        }
        return generic.uuid();
    }
}
