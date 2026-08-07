package org.uam.serviceinventario.model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="departamento")
public class Departamento {

    @Id
    @UuidGenerator
    private UUID id;

    private String nombre;

    private String descripcion;

    /*@OneToMany(
            mappedBy = "departamento"
            ,cascade = CascadeType.ALL)
    private List<Municipio> municipios;*/

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /*public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }*/
}
