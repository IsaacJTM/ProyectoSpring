package com.proyecto.listaPendientes.domain.aggregates.dto;


import lombok.Getter;
import lombok.Setter;


import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class UsuarioDTO {
    private String nombreUsuario;
    private String apellidosUsuario;
    private String email;
    private String telefono;
    private String edad;
    private Integer estadoUsuario;
    private RolDTO rol;
    private String userCreate;
    private Timestamp userDateCreate;
    private String userUpdate;
    private Timestamp userDateUpdate;
    private String userDelete;
    private Timestamp userDateDelet;
}
