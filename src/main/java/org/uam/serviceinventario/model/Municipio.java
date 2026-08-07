package org.uam.serviceinventario.model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name="municipio")
public class Municipio {
    @Id
    @UuidGenerator
    private UUID id;

    private String nombre;

    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="departamento_id")
    private Departamento departamento;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
