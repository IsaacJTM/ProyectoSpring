package com.proyecto.listaPendientes.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("api/v1/Users")
public class UsuarioController {
    @GetMapping("/delegante/Usuario")
    public ResponseEntity<String> saludar(){
       return ResponseEntity.ok("Esto e sun saludo del delegante");
    }

    @GetMapping("/responsable/Usuario")
    public ResponseEntity<String> saludarResponsable(){
        return ResponseEntity.ok("Esto e sun saludo del responsable");
    }



}
