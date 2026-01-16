package com.example.tareasSeguridad.tarea.infraestructure.rest;
import com.example.tareasSeguridad.tarea.application.TareaUseCases;
import com.example.tareasSeguridad.tarea.domain.Tarea;
import com.example.tareasSeguridad.tarea.infraestructure.db.TareaSQL;
import com.example.tareasSeguridad.usuario.domain.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TareaRest {

    private TareaUseCases tareaUseCases;

    public TareaRest(){
        tareaUseCases = new TareaUseCases(new TareaSQL());
    }

    @GetMapping("/api/tareas")
    List<Tarea> verMisTareas(@RequestBody Usuario u){
       return tareaUseCases.verMisTareas(u);
    }

    @PostMapping("/api/tareas")
    Tarea crearTarea(@RequestBody Tarea t){
        return tareaUseCases.crearTarea(t);
    }

    @GetMapping("/api/tarea/detalle/{id}")
    Tarea verDetalleTarea(@PathVariable int id){
       return tareaUseCases.verDetalleDeTarea(id);
    }

    @PutMapping("/api/tareas/{estado}/{id}")
    Tarea cambiarEstado(@PathVariable String estado, @PathVariable int id){
        return tareaUseCases.cambiarEstadoTarea(id, estado);
    }

    @PostMapping("/api/tareas/asignar/{idTarea}")
    Tarea asignarTareaUsuario(@PathVariable int idTarea, @RequestBody Usuario usuario){
        return tareaUseCases.asignarTareaunUsuario(idTarea,usuario.getEmail());
    }
}
