package com.proyecto.listaPendientes.infrastructure.adapter;

import com.proyecto.listaPendientes.domain.aggregates.dto.TareaDTO;
import com.proyecto.listaPendientes.domain.aggregates.request.RequestTarea;
import com.proyecto.listaPendientes.domain.port.out.TareaServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TareaAdapter implements TareaServiceOut {
    @Override
    public TareaDTO creaTareaOut(RequestTarea requestTarea) {
        return null;
    }

    @Override
    public Optional<TareaDTO> obtenerTareaOut(Long id) {
        return Optional.empty();
    }

    @Override
    public List<TareaDTO> obtenerTodasOut() {
        return null;
    }

    @Override
    public TareaDTO actualzarOut(Long id, RequestTarea requestTarea) {
        return null;
    }

    @Override
    public TareaDTO deleteOut(Long id) {
        return null;
    }
}
