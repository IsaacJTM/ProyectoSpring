package com.proyecto.listaPendientes.domain.port.out;

import com.proyecto.listaPendientes.domain.aggregates.dto.UsuarioDTO;
import com.proyecto.listaPendientes.domain.aggregates.response.ResponseBase;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UsuarioServiceOut {

    ResponseBase getUsuarioOut(Long id);
    ResponseBase updateUsuarioOut(Long id, UsuarioDTO usuario);
    ResponseBase deleteUsuarioOut(Long id);
    ResponseBase obtenerTodasOut();
    UserDetailsService userDetailsService();
}
