package com.example.tareasSeguridad.tarea.infraestructure.db;
import com.example.tareasSeguridad.context.db.DBConnectionPostgres;
import com.example.tareasSeguridad.tarea.domain.Tarea;
import com.example.tareasSeguridad.tarea.domain.TareaRepository;
import com.example.tareasSeguridad.usuario.domain.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TareaSQL implements TareaRepository {

    @Override
    public List<Tarea> mostrarMisTareas(Usuario u) {
        String consulta = "select * from tarea where emailusuariocreador = ?";
        List<Tarea> listaTareas = new ArrayList<>();
        try{
            PreparedStatement statement = DBConnectionPostgres.getInstance().prepareStatement(consulta);
            statement.setString(1,u.getEmail());
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                listaTareas.add(new Tarea(rs.getInt("id"),rs.getString("detalle"),rs.getString("prioridad"),rs.getString("estado"),rs.getTimestamp("fechacreacion").toString(),rs.getTimestamp("fechafinalizacion").toString(),rs.getString("emailusuariocreador")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return listaTareas;
    }

    @Override
    public Tarea verDetallesDeUnaTarea(int id) {
        String consulta = "select * from Tarea where id = ?";
        Tarea tarea = null;
        try{
            PreparedStatement statement =DBConnectionPostgres.getInstance().prepareStatement(consulta);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                tarea = new Tarea(rs.getInt("id"),rs.getString("detalle"),rs.getString("prioridad"),rs.getString("estado"),rs.getTimestamp("fechacreacion").toString(),rs.getTimestamp("fechafinalizacion").toString(),rs.getString("emailusuariocreador"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return tarea;
    }

    @Override
    public Tarea crearTarea(Tarea t) {
        String consulta = "insert into Tarea (detalle,prioridad,estado,fechacreacion,fechafinalizacion,emailusuariocreador) values (?,?,?,?,?,?)";
        try{
            PreparedStatement statement = DBConnectionPostgres.getInstance().prepareStatement(consulta);
            statement.setString(1,t.getDetalle());
            statement.setString(2,t.getPrioridad());
            statement.setString(3,t.getEstado());
            statement.setTimestamp(4, Timestamp.valueOf(t.getFechaCreacion()));
            if(t.getFechaFinalizacion() == null){
                statement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            }else{
                statement.setTimestamp(5, Timestamp.valueOf(t.getFechaFinalizacion()));
            }
            statement.setString(6,t.getEmailUsuarioCreador());
            statement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return new Tarea(t.getId(),t.getDetalle(),t.getPrioridad(),t.getEstado(),t.getFechaCreacion(),t.getFechaFinalizacion(),t.getEmailUsuarioCreador());
    }

    @Override
    public Tarea asignarTareaAUsusario(int idTarea, String emailUsuario) {
        String consulta = "insert into usuario_tarea (idtarea,emailusuario) values (?,?)";
        try{
            PreparedStatement statement = DBConnectionPostgres.getInstance().prepareStatement(consulta);
            statement.setInt(1,idTarea);
            statement.setString(2,emailUsuario);
            statement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return verDetallesDeUnaTarea(idTarea);
    }

    @Override
    public Tarea cambiarEstado(int idTarea, String estado) {
        String consulta = "update Tarea set estado = ? where id = ?";
        try{
            PreparedStatement statement= DBConnectionPostgres.getInstance().prepareStatement(consulta);
            statement.setString(1,estado);
            statement.setInt(2,idTarea);
            statement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return verDetallesDeUnaTarea(idTarea);
    }

    @Override
    public Tarea modificarTarea(int idTareaVieja, Tarea tareaNueva) {
        String consulta = "update Tarea set detalle = ? , prioridad = ? , estado = ? , fechacreacion = ? , fechafinalizacion = ? where id = ?";

        try{
            PreparedStatement statement= DBConnectionPostgres.getInstance().prepareStatement(consulta);
            statement.setString(1,tareaNueva.getDetalle());
            statement.setString(2,tareaNueva.getPrioridad());
            statement.setString(3,tareaNueva.getEstado());
            statement.setString(4,tareaNueva.getFechaCreacion());
            statement.setString(5,tareaNueva.getFechaFinalizacion());
            statement.setInt(6,tareaNueva.getId());
            statement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return new Tarea();
    }
}
