package com.proyecto.listaPendientes.domain.aggregates.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
public class TareaDTO {

    private Long idTarea;
    private String titulo;
    private String descripcion;
    private Timestamp fechaCreacion;
    private Timestamp fechaVencimiento;
    private Integer estadoTarea;
    private String userCreate;
    private Timestamp userDateCreate;
    private String userUpdate;
    private Timestamp userDateUpdate;
    private String userDelete;
    private String comentario;
    private String categoria;
    private String usuario;
}
