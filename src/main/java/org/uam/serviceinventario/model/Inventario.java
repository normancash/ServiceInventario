package org.uam.serviceinventario.model;

import jakarta.persistence.Entity;

@Entity
public class Inventario extends BaseEntity{

    private String producto;
    private Double cantidad;

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
}
