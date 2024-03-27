package com.proyecto.listaPendientes.domain.port.in;

import com.proyecto.listaPendientes.domain.aggregates.dto.TareaDTO;
import com.proyecto.listaPendientes.domain.aggregates.dto.UsuarioDTO;
import com.proyecto.listaPendientes.domain.aggregates.response.ResponseBase;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UsuarioServiceIn {
    ResponseBase getUsuarioIn(Long id);
    ResponseBase updateUsuarioIn(Long id, UsuarioDTO usuario);
    ResponseBase deleteUsuarioIn(Long id);
    ResponseBase obtenerTodasIn();
    UserDetailsService userDetailsServiceIn();
}
