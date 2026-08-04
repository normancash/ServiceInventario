package org.uam.serviceinventario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.uam.serviceinventario.dto.CategoriaDTO;
import org.uam.serviceinventario.dto.GenericoDTO;
import org.uam.serviceinventario.mapper.config.CentralMapperConfig;
import org.uam.serviceinventario.model.BaseEntity;

@Mapper(config = CentralMapperConfig.class)
public interface GenericFieldMapper {

    @Named("toGenericDTO")
    GenericoDTO toGenericDTO(BaseEntity entity);

    @Named("updateFromGenericDTO")
    void updateEntityFromGenericDTO(GenericoDTO dto
            , @MappingTarget BaseEntity entity);
}
