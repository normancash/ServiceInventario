package org.uam.serviceinventario.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.Audited;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Audited
public class BaseEntity {

    @Id
    @UuidGenerator
    private UUID uuid;

    @CreatedBy
    private String usuarioIns;

    @LastModifiedBy
    private String usuarioUpd;

    @CreatedDate
    private LocalDateTime fechaIns;

    @LastModifiedDate
    private LocalDateTime fechaUpd;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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
}
