package com.example.tareasSeguridad.usuario.infraestructure.rest;

import com.example.tareasSeguridad.usuario.application.UsuarioUseCases;
import com.example.tareasSeguridad.usuario.domain.Usuario;
import com.example.tareasSeguridad.usuario.domain.UsuarioRepository;
import com.example.tareasSeguridad.usuario.infraestructure.db.UsuarioPostgresRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioRestController {

    private UsuarioUseCases usuarioUseCases;

    public UsuarioRestController(){
        this.usuarioUseCases = new UsuarioUseCases(new UsuarioPostgresRepository());
    }

    @PostMapping("/api/usuarios/registro")
    boolean registrarse(@RequestBody Usuario usuario){

       return usuarioUseCases.registrarse(usuario);
    }

    @PostMapping("/api/usuarios/login")
    Usuario login(@RequestBody Usuario usuario){
        return usuarioUseCases.login(usuario);
    }

}
