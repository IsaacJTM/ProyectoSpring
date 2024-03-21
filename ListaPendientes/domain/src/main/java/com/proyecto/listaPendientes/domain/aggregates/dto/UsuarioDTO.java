package com.proyecto.listaPendientes.domain.aggregates.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class UsuarioDTO {
    private String nombreUsuario;
    private String apellidosUsuario;
    private String email;
    private String telefono;
    private String edad;
    private Integer estadoUsuario;
}
