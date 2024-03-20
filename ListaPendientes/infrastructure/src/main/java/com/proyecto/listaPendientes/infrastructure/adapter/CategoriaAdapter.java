package com.proyecto.listaPendientes.infrastructure.adapter;

import com.proyecto.listaPendientes.domain.aggregates.dto.CategoriaDTO;
import com.proyecto.listaPendientes.domain.aggregates.request.RequestCategoria;
import com.proyecto.listaPendientes.domain.port.out.CategoriaServiceOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaAdapter implements CategoriaServiceOut{

    @Override
    public CategoriaDTO crearCategoriaOut(RequestCategoria requestCategoria) {
        return null;
    }

    @Override
    public Optional<CategoriaDTO> obtenerCategoriaOut(Long id) {
        return Optional.empty();
    }

    @Override
    public List<CategoriaDTO> obtenerCategoriaAllOut() {
        return null;
    }

    @Override
    public CategoriaDTO actualzarCategoriaOut(Long id, RequestCategoria requestCategoria) {
        return null;
    }

    @Override
    public CategoriaDTO deleteCategoriaOut(Long id) {
        return null;
    }
}
