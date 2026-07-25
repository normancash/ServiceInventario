package org.uam.serviceinventario.controller;

import jakarta.validation.Valid;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.uam.serviceinventario.dto.AdministradorDTO;
import org.uam.serviceinventario.dto.AdministradorDTOM;
import org.uam.serviceinventario.model.Administrador;
import org.uam.serviceinventario.service.FileService;
import org.uam.serviceinventario.service.ServiceAdministrador;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class ControllerAdministrador {

    private final ServiceAdministrador service;


    public ControllerAdministrador(ServiceAdministrador service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<AdministradorDTOM> listarAdministradores(){
        return service.findAll();
    }

    @PostMapping("/create")
    public AdministradorDTO crearAdministrador(@RequestBody @Valid AdministradorDTO administradorDTO){
        return service.save(administradorDTO);
    }

    @PostMapping(value = "/createImage",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public AdministradorDTO crearAdmnistrador(@RequestParam(value="nombre") String nombre,
                                             @RequestParam(value="apellido") String apellido,
                                             @RequestParam(value="email") String email,
                                             @RequestParam(value="cedula") String cedula,
                                             @RequestParam(value="areaAdministrativa") String areaAdministrativa,
                                             @RequestParam(value="imagen") MultipartFile imagen
                                             ) throws Exception {
       return service.save(
                    nombre,apellido,email,cedula,areaAdministrativa,imagen
               );
    }

    @PostMapping("/imagen/{filename:.+}")
    public ResponseEntity<Resource> loadImage(@PathVariable String filename) throws Exception {
        Resource resource = service.loadImagen(filename);
        String tipo = filename.endsWith(".png") ? "image/png" : "image/jpeg";
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(tipo)).body(resource);
    }

    @PutMapping("/update")
    public AdministradorDTO actualizarAdministrador(@RequestBody AdministradorDTO administradorDTO){
        if (administradorDTO.uuid() == null){
            throw new RuntimeException("No existe el id para actualizar");
        }
        return service.save(administradorDTO);
    }


}
