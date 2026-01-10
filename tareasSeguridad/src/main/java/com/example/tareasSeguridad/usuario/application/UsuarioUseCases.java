package com.example.tareasSeguridad.usuario.application;

import com.example.tareasSeguridad.usuario.domain.UsuarioRepository;

public class UsuarioUseCases {

    private UsuarioRepository usuarioRepository;

    public UsuarioUseCases(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

}
