package com.proyecto.listaPendientes.domain.port.in;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTServiceIn {

    String generarTokenIn(UserDetails userDetails);
    boolean validarTokenIn(String token, UserDetails userDetails);
    String extractUserNameIn(String token);

}
