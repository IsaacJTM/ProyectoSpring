package com.proyecto.listaPendientes.domain.impl;

import com.proyecto.listaPendientes.domain.port.in.JWTServiceIn;
import com.proyecto.listaPendientes.domain.port.out.JWTServiceOut;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JWTServiceImpl implements JWTServiceIn{

    private final JWTServiceOut jwtServiceOut;
    @Override
    public String generarTokenIn(UserDetails userDetails) {
        return jwtServiceOut.generarTokenOut(userDetails);
    }

    @Override
    public boolean validarTokenIn(String token, UserDetails userDetails) {
        return jwtServiceOut.validarTokenOut(token, userDetails);
    }

    @Override
    public String extractUserNameIn(String token) {
        return jwtServiceOut.extractUserNameOut(token);
    }
}
