package org.uam.serviceinventario.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarioadministrador")
public class Administrador extends Usuario{
    private String areaAdministrativa;

    public String getAreaAdministrativa() {
        return areaAdministrativa;
    }

    public void setAreaAdministrativa(String areaAdministrativa) {
        this.areaAdministrativa = areaAdministrativa;
    }
}
