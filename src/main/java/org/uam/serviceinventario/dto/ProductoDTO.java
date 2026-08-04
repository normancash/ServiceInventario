package org.uam.serviceinventario.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class ProductoDTO {
    private UUID uuid;
    private String nombre;
    private String descripcion;
    private String usuarioIns;
    private String usuarioUpd;
    private LocalDateTime fechaIns;
    private LocalDateTime fechaUpd;



    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuarioIns() {
        return usuarioIns;
    }

    public void setUsuarioIns(String usuarioIns) {
        this.usuarioIns = usuarioIns;
    }

    public String getUsuarioUpd() {
        return usuarioUpd;
    }

    public void setUsuarioUpd(String usuarioUpd) {
        this.usuarioUpd = usuarioUpd;
    }

    public LocalDateTime getFechaIns() {
        return fechaIns;
    }

    public void setFechaIns(LocalDateTime fechaIns) {
        this.fechaIns = fechaIns;
    }

    public LocalDateTime getFechaUpd() {
        return fechaUpd;
    }

    public void setFechaUpd(LocalDateTime fechaUpd) {
        this.fechaUpd = fechaUpd;
    }
}
