package com.proyecto.listaPendientes.domain.aggregates.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class CategoriaDTO {

    private Long idCategoria;
    private String nombreCategoria;
    private String descripcionCategoria;
    private Integer estadoParestesco;
    private String userCreate;
    private Timestamp userDateCreate;
    private String userUpdate;
    private Timestamp userDateUpdate;
    private String userDelete;

}
