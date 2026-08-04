package org.uam.serviceinventario.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uam.serviceinventario.dto.PersonaDTO;
import org.uam.serviceinventario.service.PersonaService;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class ControllerPersona {

    private final PersonaService service;

    public ControllerPersona(PersonaService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<PersonaDTO> save(PersonaDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }
    @GetMapping("/all")
    public ResponseEntity<List<PersonaDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/update")
    public ResponseEntity<PersonaDTO> update(@RequestBody PersonaDTO dto)
    {
        return ResponseEntity.ok(service.update(dto));
    }
}
