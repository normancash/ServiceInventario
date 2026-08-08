package org.uam.serviceinventario.mapper;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.uam.serviceinventario.dto.GenericoDTO;
import org.uam.serviceinventario.dto.ProductoDTO;
import org.uam.serviceinventario.model.Producto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-07T20:59:07-0600",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class ProductoMapperImpl implements ProductoMapper {

    @Override
    public ProductoDTO toDTO(Producto entity) {
        if ( entity == null ) {
            return null;
        }

        GenericoDTO generic = null;
        String nombre = null;
        String descripcion = null;

        if ( entity != null ) {
            generic = productoToGenericoDTO( entity );
        }
        if ( entity.getNombre() != null ) {
            nombre = entity.getNombre();
        }
        if ( entity.getDescripcion() != null ) {
            descripcion = entity.getDescripcion();
        }

        ProductoDTO productoDTO = new ProductoDTO( generic, nombre, descripcion );

        return productoDTO;
    }

    @Override
    public Producto toEntity(ProductoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Producto producto = new Producto();

        if ( dto.nombre() != null ) {
            producto.setNombre( dto.nombre() );
        }
        if ( dto.descripcion() != null ) {
            producto.setDescripcion( dto.descripcion() );
        }

        return producto;
    }

    protected GenericoDTO productoToGenericoDTO(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        UUID uuid = null;
        String usuarioIns = null;
        String usuarioUpd = null;
        LocalDateTime fechaIns = null;
        LocalDateTime fechaUpd = null;

        if ( producto.getUuid() != null ) {
            uuid = producto.getUuid();
        }
        if ( producto.getUsuarioIns() != null ) {
            usuarioIns = producto.getUsuarioIns();
        }
        if ( producto.getUsuarioUpd() != null ) {
            usuarioUpd = producto.getUsuarioUpd();
        }
        if ( producto.getFechaIns() != null ) {
            fechaIns = producto.getFechaIns();
        }
        if ( producto.getFechaUpd() != null ) {
            fechaUpd = producto.getFechaUpd();
        }

        GenericoDTO genericoDTO = new GenericoDTO( uuid, usuarioIns, usuarioUpd, fechaIns, fechaUpd );

        return genericoDTO;
    }
}
