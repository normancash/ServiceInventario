package org.uam.serviceinventario.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.uam.serviceinventario.dto.AdministradorDTO;
import org.uam.serviceinventario.dto.AdministradorDTOM;
import org.uam.serviceinventario.model.Administrador;
import org.uam.serviceinventario.repository.AdministradorRepo;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class ServiceAdministrador {

    private final AdministradorRepo administradorRepo;
    private final ModelMapper modelMapper;

    public ServiceAdministrador(AdministradorRepo administradorRepo, ModelMapper modelMapper) {
        this.administradorRepo = administradorRepo;
        this.modelMapper = modelMapper;
    }

    public List<AdministradorDTOM> findAll() {
        return administradorRepo.findAll().stream()
                .map(admin -> modelMapper.map(admin, AdministradorDTOM.class))
                .collect(Collectors.toList()
        );
    }

    public AdministradorDTO findById(UUID id) {
       return administradorRepo.findById(id)
               .map(this::convertToDTO)
               .orElseThrow(()->new RuntimeException("No existe el administrador, con id: " + id.toString()));
    }

    public AdministradorDTO save(AdministradorDTO administradorDTO) {
        return convertToDTO(administradorRepo.save(convertToEntity(administradorDTO)));
    }

    private Administrador convertToEntity(AdministradorDTO dto) {
        Administrador administrador = new Administrador();
        administrador.setUuid(dto.uuid());
        administrador.setNombre(dto.nombre());
        administrador.setApellido(dto.apellido());
        administrador.setEmail(dto.email());
        administrador.setCedula(dto.cedula());
        administrador.setAreaAdministrativa(dto.areaAdministrativa());
        return administrador;
    }

    private AdministradorDTO convertToDTO(Administrador entity) {
        return new AdministradorDTO(
          entity.getUuid(),
          entity.getNombre(),
          entity.getApellido(),
          entity.getEmail(),
          entity.getCedula(),
          entity.getAreaAdministrativa()
        );
    }

}
