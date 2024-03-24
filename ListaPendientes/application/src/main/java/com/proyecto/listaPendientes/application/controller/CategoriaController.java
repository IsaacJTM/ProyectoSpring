package com.proyecto.listaPendientes.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/v1/admin/Categoria")
public class CategoriaController {

    @GetMapping()
    public ResponseEntity<String> saludarAdmin(){
        return ResponseEntity.ok("Esto e sun saludo del Administrador");
    }
}
