package com.proyecto.listaPendientes.domain.aggregates.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TareaDTO {
    private long idtarea;
    private String tarea;
    private String descripción;
}
