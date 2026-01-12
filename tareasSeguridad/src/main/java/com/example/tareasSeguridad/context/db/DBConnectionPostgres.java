package com.example.tareasSeguridad.context.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionPostgres {
    private static Connection connection;

    private DBConnectionPostgres(){
    }

    public static Connection getInstance() {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://database-1.cfkmi4o0agyw.us-east-1.rds.amazonaws.com/tareas", "postgres", "monzon2025");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return DBConnectionPostgres.connection;
    }
}
