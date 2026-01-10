package com.example.tareasSeguridad.tarea.application;

import com.example.tareasSeguridad.tarea.domain.TareaRepository;

public class TareaUseCases {

    private TareaRepository tareaRepository;

    public TareaUseCases(TareaRepository tareaRepository){
        this.tareaRepository = tareaRepository;
    }

}
