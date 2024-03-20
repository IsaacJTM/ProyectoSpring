package com.proyecto.listaPendientes.domain.port.out;

import com.proyecto.listaPendientes.domain.aggregates.dto.TareaDTO;
import com.proyecto.listaPendientes.domain.aggregates.request.RequestTarea;

import java.util.List;
import java.util.Optional;

public interface TareaServiceOut {


    TareaDTO creaTareaOut(RequestTarea requestTarea);
    Optional<TareaDTO> obtenerTareaOut(Long id);
    List<TareaDTO> obtenerTodasOut();
    TareaDTO actualzarOut(Long id, RequestTarea requestTarea);
    TareaDTO deleteOut(Long id);

}
