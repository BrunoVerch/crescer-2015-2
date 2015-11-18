package br.com.cwi.crescer.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {
        String strConexao = "jdbc:oracle:thin:@localhost:1521:xe";
        //"jdbc:mysql://localhost/crescer"
        return DriverManager.getConnection(strConexao, "LAVANDERIA", "LAVANDERIA");
    }
}
