package com.example.tareasSeguridad.tarea.infraestructure.rest;

import com.example.tareasSeguridad.tarea.application.TareaUseCases;
import com.example.tareasSeguridad.tarea.infraestructure.db.TareaSQL;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TareaRest {

    private TareaUseCases tareaUseCases;

    public TareaRest(){
        tareaUseCases = new TareaUseCases(new TareaSQL());
    }

}
