package com.proyecto.listaPendientes.domain.port.in;

import com.proyecto.listaPendientes.domain.aggregates.dto.UsuarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UsuarioServiceIn {
    Optional<UsuarioDTO> getUsuarioIn(Long id);
    UsuarioDTO updateUsuarioIn(Long id, UsuarioDTO usuario);
    UsuarioDTO deleteUsuarioIn(Long id);
    UserDetailsService userDetailsServiceIn();
}
