package com.example.tareasSeguridad.usuario.infraestructure.db;

import com.example.tareasSeguridad.context.db.DBConnectionPostgres;
import com.example.tareasSeguridad.usuario.domain.Usuario;
import com.example.tareasSeguridad.usuario.domain.UsuarioRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioPostgresRepository implements UsuarioRepository {

    @Override
    public Usuario login(Usuario usuario) {
        String consulta = "select * from usuario where email = ?";
        try{
            PreparedStatement statement = DBConnectionPostgres.getInstance().prepareStatement(consulta);
            statement.setString(1,usuario.getEmail());
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                return new Usuario(rs.getString("email"),rs.getString("password"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean registro(Usuario usuario) {
        String consulta = "insert into usuario (email,password) values (?,?)";
        try{
            PreparedStatement statement = DBConnectionPostgres.getInstance().prepareStatement(consulta);
            statement.setString(1,usuario.getEmail());
            statement.setString(2,usuario.getPassword());
            statement.execute();
            return true;
        }catch (SQLException e){
            return false;
        }
    }
}
