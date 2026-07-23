package org.uam.serviceinventario.dto;

import java.util.UUID;

public class AdministradorDTOM {

    private  UUID uuid;
    private String nombre;
    private String apellido;
    private String email;
    private String cedula;
    private String areaAdministrativa;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getAreaAdministrativa() {
        return areaAdministrativa;
    }

    public void setAreaAdministrativa(String areaAdministrativa) {
        this.areaAdministrativa = areaAdministrativa;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
