package com.example.tareasSeguridad.tarea.domain;

import com.example.tareasSeguridad.usuario.domain.Usuario;
import com.example.tareasSeguridad.usuario.domain.UsuarioRepository;

import java.util.List;

public interface TareaRepository {

    List<Tarea> mostrarMisTareas(Usuario u);

    Tarea verDetallesDeUnaTarea(Tarea t);

    Tarea crearTarea(Tarea t);

    Tarea asignarTareaAUsusario(Tarea t, Usuario u);

    Tarea cambiarEstado(Tarea t, String estado);

    Tarea modificarTarea(Tarea t, Tarea tareaNueva);


}
