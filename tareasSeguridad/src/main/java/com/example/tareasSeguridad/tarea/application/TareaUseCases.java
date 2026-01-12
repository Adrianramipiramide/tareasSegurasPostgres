package com.example.tareasSeguridad.tarea.application;

import com.example.tareasSeguridad.tarea.domain.Tarea;
import com.example.tareasSeguridad.tarea.domain.TareaRepository;
import com.example.tareasSeguridad.usuario.domain.Usuario;
import jdk.dynalink.linker.LinkerServices;

import java.util.List;

public class TareaUseCases {

    private TareaRepository tareaRepository;

    public TareaUseCases(TareaRepository tareaRepository){
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> verMisTareas(Usuario u){

       return tareaRepository.mostrarMisTareas(u);
    }

    public Tarea crearTarea(Tarea t){
        return tareaRepository.crearTarea(t);
    }

}
