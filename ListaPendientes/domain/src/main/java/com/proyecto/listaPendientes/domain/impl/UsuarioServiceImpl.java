package com.proyecto.listaPendientes.domain.impl;

import com.proyecto.listaPendientes.domain.aggregates.dto.UsuarioDTO;
import com.proyecto.listaPendientes.domain.aggregates.response.ResponseBase;
import com.proyecto.listaPendientes.domain.port.in.UsuarioServiceIn;
import com.proyecto.listaPendientes.domain.port.out.UsuarioServiceOut;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioServiceIn {
    private final UsuarioServiceOut usuarioServiceOut;

    @Override
    public ResponseBase getUsuarioIn(Long id) {
        return usuarioServiceOut.getUsuarioOut(id);
    }

    @Override
    public ResponseBase updateUsuarioIn(Long id, UsuarioDTO usuario) {
        return usuarioServiceOut.updateUsuarioOut(id, usuario);
    }

    @Override
    public ResponseBase deleteUsuarioIn(Long id) {
        return usuarioServiceOut.deleteUsuarioOut(id);
    }

    @Override
    public ResponseBase obtenerTodasIn() {
        return usuarioServiceOut.obtenerTodasOut();
    }

    @Override
    public UserDetailsService userDetailsServiceIn() {
        return usuarioServiceOut.userDetailsService();
    }
}
