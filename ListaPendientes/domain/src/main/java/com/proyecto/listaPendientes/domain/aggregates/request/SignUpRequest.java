package com.proyecto.listaPendientes.domain.aggregates.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String role;
}
