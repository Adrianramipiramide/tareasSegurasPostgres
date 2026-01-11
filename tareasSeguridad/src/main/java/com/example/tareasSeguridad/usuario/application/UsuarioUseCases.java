package com.example.tareasSeguridad.usuario.application;

import com.example.tareasSeguridad.usuario.domain.Usuario;
import com.example.tareasSeguridad.usuario.domain.UsuarioRepository;

public class UsuarioUseCases {

    private UsuarioRepository usuarioRepository;

    public UsuarioUseCases(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public boolean login(Usuario usuario){
        usuarioRepository.login(usuario);
    }

}
