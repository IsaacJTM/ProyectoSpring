package com.proyecto.listaPendientes.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "usuario")
@RequiredArgsConstructor
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombre_usuario", nullable = false, length = 45)
    private String nombreUsuario;

    @Column(name = "apellidos_usuario", nullable = false, length = 45)
    private String apellidosUsuario;


    @Column(name = "email", nullable = false, length = 65)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "telefono", nullable = false, length = 9)
    private String telefono;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "estado_usuario", nullable = false)
    private Integer estadoUsuario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_rol_fk", nullable = false)
    private RolEntity rol;

    @Column(name = "usua_create", length = 45)
    private String userCreate;

    @Column(name = "user_date_create")
    private Timestamp userDateCreate;

    @Column(name = "user_update", length = 45)
    private String userUpdate;

    @Column(name = "user_date_update")
    private Timestamp userDateUpdate;

    @Column(name = "user_delete", length = 45)
    private String userDelete;
}
