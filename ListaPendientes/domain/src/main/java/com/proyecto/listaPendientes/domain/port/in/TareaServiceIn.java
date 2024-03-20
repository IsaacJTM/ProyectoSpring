package com.proyecto.listaPendientes.domain.port.in;

import com.proyecto.listaPendientes.domain.aggregates.dto.TareaDTO;
import com.proyecto.listaPendientes.domain.aggregates.request.RequestTarea;

import java.util.List;
import java.util.Optional;


public interface TareaServiceIn {

    TareaDTO crearTareaIn(RequestTarea requestTarea);
    Optional<TareaDTO> obtenerTareaIn(Long id);
    List<TareaDTO> obtenerTodasIn();
    TareaDTO actualzarTareaIn(Long id, RequestTarea requestTarea);
    TareaDTO deleteTareaIn(Long id);


}
