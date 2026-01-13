package com.example.tareasSeguridad.tarea.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class Tarea {
    int id;
    String detalle;
    String prioridad;
    String estado;
    String fechaCreacion;
    String fechaFinalizacion;
    String emailUsuarioCreador;

    public Tarea(int id, String detalle, String prioridad, String estado, String fechaCreacion, String fechaFinalizacion, String emailUsuarioCreador) {
        this.id = id;
        this.detalle = detalle;
        this.prioridad = prioridad;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaFinalizacion = fechaFinalizacion;
        this.emailUsuarioCreador = emailUsuarioCreador;
    }

    public int getId() {
        return id;
    }

    public String getDetalle() {
        return detalle;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public String getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public String getEmailUsuarioCreador() {
        return emailUsuarioCreador;
    }
}
