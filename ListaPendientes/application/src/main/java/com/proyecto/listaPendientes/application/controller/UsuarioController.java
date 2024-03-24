package com.proyecto.listaPendientes.application.controller;

import com.proyecto.listaPendientes.domain.aggregates.dto.UsuarioDTO;
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
    @GetMapping("Users/responsable/ObtenerUser")
    public ResponseEntity<Optional<UsuarioDTO>> getUsuarioResponsable(@PathVariable Long id){
        return ResponseEntity.ok(usuarioServiceIn.getUsuarioIn(id));
    }
    @GetMapping("Users/delegante/ObtenerUser")
    public ResponseEntity<Optional<UsuarioDTO>> getUsuarioDelegate(@PathVariable Long id){
        return ResponseEntity.ok(usuarioServiceIn.getUsuarioIn(id));
    }

    @GetMapping("Users/responsable/ActualizarUser")
    public ResponseEntity<UsuarioDTO> updateUsuarioRespnsable(@PathVariable Long id,@RequestBody UsuarioDTO usuario){
        return ResponseEntity.ok(usuarioServiceIn.updateUsuarioIn(id,usuario));
    }
    @GetMapping("Users/delegante/ActualizarUser")
    public ResponseEntity<UsuarioDTO> updateUsuarioDelegante(@PathVariable Long id,@RequestBody UsuarioDTO usuario){
        return ResponseEntity.ok(usuarioServiceIn.updateUsuarioIn(id,usuario));
    }
    @GetMapping("admin/EliminarUsuario")
    public ResponseEntity<UsuarioDTO> deleteUsuario(@PathVariable Long id){
        return ResponseEntity.ok(usuarioServiceIn.deleteUsuarioIn(id));
    }


}
