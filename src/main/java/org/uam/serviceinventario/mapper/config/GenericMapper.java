package org.uam.serviceinventario.mapper.config;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

public interface GenericMapper <E,D>{

     D toDTO(E entity);
     E toEntity(D dto);

     @BeanMapping(nullValuePropertyMappingStrategy
             = NullValuePropertyMappingStrategy.IGNORE)
     void updateFromDTO(D dto, @MappingTarget E entity);

     List<D> toDTOList(List<E> entityList);

     List<E> toEntityList(List<D> dtoList);
}


