package org.uam.serviceinventario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.uam.serviceinventario.dto.CategoriaDTO;
import org.uam.serviceinventario.mapper.config.CentralMapperConfig;
import org.uam.serviceinventario.mapper.config.GenericMapper;
import org.uam.serviceinventario.model.Categoria;

@Mapper(config = CentralMapperConfig.class
,uses = {GenericFieldMapper.class})
public interface CategoriaMapper extends GenericMapper<Categoria, CategoriaDTO> {

    @Override
    @Mapping(target = "generic", source = "entity")
    CategoriaDTO toDTO(Categoria entity);


    @Override
    @Mapping(target = "uuid", source = "dto.generic.uuid")
    Categoria toEntity(CategoriaDTO dto);

}

