package com.example.tareasSeguridad.usuario.domain;

public interface UsuarioRepository {

    public Usuario login(Usuario usuario);

    public Boolean registro(Usuario usuario);
}
