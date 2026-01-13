package com.example.tareasSeguridad.tarea.infraestructure.rest;

import com.example.tareasSeguridad.tarea.application.TareaUseCases;
import com.example.tareasSeguridad.tarea.domain.Tarea;
import com.example.tareasSeguridad.tarea.infraestructure.db.TareaSQL;
import com.example.tareasSeguridad.usuario.domain.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TareaRest {

    private TareaUseCases tareaUseCases;

    public TareaRest(){
        tareaUseCases = new TareaUseCases(new TareaSQL());
    }

    @GetMapping("/api/tareas")
    List<Tarea> verMisTareas(Usuario u){
       return tareaUseCases.verMisTareas(u);
    }

    @PostMapping("/api/tareas")
    Tarea crearTarea(@RequestBody Tarea t){
        return tareaUseCases.crearTarea(t);
    }
}
