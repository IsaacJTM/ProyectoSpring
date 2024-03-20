package com.proyecto.listaPendientes.domain.port.in;

import com.proyecto.listaPendientes.domain.aggregates.dto.CategoriaDTO;
import com.proyecto.listaPendientes.domain.aggregates.dto.TareaDTO;
import com.proyecto.listaPendientes.domain.aggregates.request.RequestTarea;

import java.util.List;
import java.util.Optional;

public interface CategoriaServiceIn {
    TareaDTO creaTareaIn(RequestTarea requestTarea);
    Optional<TareaDTO> obtenerTareaIn(Long id);
    List<TareaDTO> obtenerTodasIn();
    TareaDTO actualzarIn(Long id, RequestTarea requestTarea);
    TareaDTO deleteIn(Long id);
}
