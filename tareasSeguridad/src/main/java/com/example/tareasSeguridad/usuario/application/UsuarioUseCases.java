package com.example.tareasSeguridad.usuario.application;

import com.example.tareasSeguridad.usuario.domain.Usuario;
import com.example.tareasSeguridad.usuario.domain.UsuarioRepository;

public class UsuarioUseCases {

    private UsuarioRepository usuarioRepository;

    public UsuarioUseCases(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario login(Usuario usuario){
     return usuarioRepository.login(usuario);
    }

    public boolean registrarse(Usuario usuario){
        return usuarioRepository.registro(usuario);
    }

}
