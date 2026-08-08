package org.uam.serviceinventario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.uam.serviceinventario.dto.ProductoDTO;
import org.uam.serviceinventario.mapper.config.CentralMapperConfig;
import org.uam.serviceinventario.mapper.config.EntityIdMapper;
import org.uam.serviceinventario.model.Producto;

@Mapper(
        config= CentralMapperConfig.class
        ,uses={GenericFieldMapper.class,
               EntityIdMapper.class}
)
public interface ProductoMapper {

     @Mapping(target="generic",source=".")
     @Mapping(target="idCategoria"
             ,source="categoria"
             ,qualifiedByName = "entityToId"
     )
     ProductoDTO toDTO(Producto entity);

     @Mapping(target="generic",ignore=true)
     @Mapping(
             target="categoria"
             ,source="idCategoria"
             ,qualifiedByName = "idToEntity"
     )
     Producto toEntity(ProductoDTO dto);
}
