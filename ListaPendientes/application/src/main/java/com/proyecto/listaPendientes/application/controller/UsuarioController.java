package com.proyecto.listaPendientes.application.controller;

import com.proyecto.listaPendientes.domain.aggregates.dto.UsuarioDTO;
import com.proyecto.listaPendientes.domain.aggregates.response.ResponseBase;
import com.proyecto.listaPendientes.domain.port.in.UsuarioServiceIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping ("api/v1")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioServiceIn usuarioServiceIn;
    @GetMapping("Users/responsable/ObtenerUser/{id}")
    public ResponseBase getUsuarioResponsable(@PathVariable Long id){
        return usuarioServiceIn.getUsuarioIn(id);
    }
    @GetMapping("Users/delegante/ObtenerUser/{id}")
    public ResponseBase getUsuarioDelegate(@PathVariable Long id){
        return usuarioServiceIn.getUsuarioIn(id);
    }

    @GetMapping("Users/responsable/ActualizarUser/{id}")
    public ResponseBase updateUsuarioRespnsable(@PathVariable Long id,@RequestBody UsuarioDTO usuario){
        return usuarioServiceIn.updateUsuarioIn(id,usuario);
    }
    @GetMapping("Users/delegante/ActualizarUser/{id}")
    public ResponseBase updateUsuarioDelegante(@PathVariable Long id,@RequestBody UsuarioDTO usuario){
        return usuarioServiceIn.updateUsuarioIn(id,usuario);
    }
    @GetMapping("admin/EliminarUsuario/{id}")
    public ResponseBase deleteUsuario(@PathVariable Long id){
        return usuarioServiceIn.deleteUsuarioIn(id);
    }

    @GetMapping("admin/ObtenerUser")
    public ResponseBase listaUsuarios(){
        return usuarioServiceIn.obtenerTodasIn();
    }


}
