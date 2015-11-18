package br.com.cwi.crescer;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.cwi.crescer.jdbc.ConnectionFactory;

public class Aplicacao1 {

	public static void main(String[] args) throws SQLException {
		try{
			Connection con=new ConnectionFactory().getConnection();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}

	}

}
