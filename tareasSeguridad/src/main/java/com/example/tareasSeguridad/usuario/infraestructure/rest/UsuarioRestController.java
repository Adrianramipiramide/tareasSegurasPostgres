package com.example.tareasSeguridad.usuario.infraestructure.rest;

import com.example.tareasSeguridad.usuario.application.UsuarioUseCases;
import com.example.tareasSeguridad.usuario.domain.UsuarioRepository;
import com.example.tareasSeguridad.usuario.infraestructure.db.UsuarioPostgresRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioRestController {

    private UsuarioUseCases usuarioUseCases;

    public UsuarioRestController(){
        this.usuarioUseCases = new UsuarioUseCases(new UsuarioPostgresRepository());
    }

}
