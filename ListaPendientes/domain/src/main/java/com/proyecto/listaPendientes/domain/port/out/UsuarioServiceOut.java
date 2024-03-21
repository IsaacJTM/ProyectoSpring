package com.proyecto.listaPendientes.domain.port.out;

import com.proyecto.listaPendientes.domain.aggregates.dto.UsuarioDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UsuarioServiceOut {

    Optional<UsuarioDTO> getUsuarioOut(Long id);
    UsuarioDTO updateUsuarioOut(Long id, UsuarioDTO usuario);
    UsuarioDTO deleteUsuarioOut(Long id);
    UserDetailsService userDetailsService();
}
