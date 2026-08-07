package org.uam.serviceinventario.mapper;

import org.mapstruct.Mapper;
import org.uam.serviceinventario.dto.DepartamentoDTO;
import org.uam.serviceinventario.model.Departamento;

@Mapper(componentModel = "spring")
public interface DepartamentoMapper {

    DepartamentoDTO toDto(Departamento departamento);

    Departamento toEntity(DepartamentoDTO dto);
}
