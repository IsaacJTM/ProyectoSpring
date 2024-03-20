package com.proyecto.listaPendientes.domain.impl;

import com.proyecto.listaPendientes.domain.aggregates.dto.TareaDTO;
import com.proyecto.listaPendientes.domain.aggregates.request.RequestTarea;
import com.proyecto.listaPendientes.domain.port.in.TareaServiceIn;
import com.proyecto.listaPendientes.domain.port.out.TareaServiceOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TareaServiceImpl implements TareaServiceIn {

    private final TareaServiceOut tareaServiceOut;
    @Override
    public TareaDTO creaTareaIn(RequestTarea requestTarea) {

        return tareaServiceOut.creaTareaOut(requestTarea);
    }

    @Override
    public Optional<TareaDTO> obtenerTareaIn(Long id) {

        return tareaServiceOut.obtenerTareaOut(id);
    }

    @Override
    public List<TareaDTO> obtenerTodasIn() {
        return tareaServiceOut.obtenerTodasOut();
    }

    @Override
    public TareaDTO actualzarIn(Long id, RequestTarea requestTarea) {
        return tareaServiceOut.actualzarOut(id, requestTarea);
    }

    @Override
    public TareaDTO deleteIn(Long id) {
        return tareaServiceOut.deleteOut(id);
    }
}
