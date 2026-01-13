package com.example.tareasSeguridad.usuario.infraestructure.rest;

import com.example.tareasSeguridad.context.security.JwtService;
import com.example.tareasSeguridad.usuario.application.UsuarioUseCases;
import com.example.tareasSeguridad.usuario.domain.Usuario;
import com.example.tareasSeguridad.usuario.infraestructure.db.UsuarioPostgresRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthRestController {

    private final JwtService jwtService;
    private UsuarioUseCases usuarioUseCases;
    public AuthRestController(JwtService jwtService){
        this.jwtService = jwtService;
        this.usuarioUseCases = new UsuarioUseCases(new UsuarioPostgresRepository());
    }

    @PostMapping("/auth/usuarios/registro")
    boolean registrarse(@RequestBody Usuario usuario){

        boolean correcto = this.usuarioUseCases.registrarse(usuario);

        if(correcto){
            return true;
        }else{
            return false;
        }

    }

    @PostMapping("/auth/usuarios/login")
    String login(@RequestBody Usuario usuario){
        Usuario login = this.usuarioUseCases.login(usuario);

        if(login != null) {
            return jwtService.generateToken(login.getEmail());
        }else {
            return "contraseña incorrecta";
        }
    }

}
