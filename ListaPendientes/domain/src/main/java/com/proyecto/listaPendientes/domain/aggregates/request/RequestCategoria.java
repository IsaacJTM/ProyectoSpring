package com.proyecto.listaPendientes.domain.aggregates.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class RequestCategoria {
    private String nombreCategoria;
    private String descripcion;
}
