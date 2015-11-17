package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Cliente;

public class ClienteDao {
	
	public void insert(Cliente cliente) throws SQLException{
		try(Connection conexao = new ConnectionFactory().getConnection()){
			
			PreparedStatement statement = conexao.prepareStatement("INSERT INTO cliente (idCliente,nmCliente,nrCpf) VALUES (?,?,?)");
			statement.setLong(1, cliente.getIdCliente());
			statement.setString(2, cliente.getNmCliente());
			statement.setString(3, cliente.getNrCpf());
			statement.execute();
		
			/*Statement stmt = conexao.createStatement();
			stmt.execute(" INSERT INTO cliente (idCliente,nmCliente,nrCpf) VALUES ("+cliente.getIdCliente()+", '" + cliente.getNmCliente()+"', '"+cliente.getNrCpf()+"') ");		
			stmt.close();*/
			
		} catch(SQLException e){
			throw e;
		}
	}
	
	public List<Cliente> listAll() throws SQLException{
		List<Cliente> lista = new ArrayList<Cliente>();
		try(Connection conexao = new ConnectionFactory().getConnection()){
			PreparedStatement statement = conexao.prepareStatement("SELECT idCliente,nmCliente,nrCpf FROM cliente");
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next()){
				Cliente cliente = new Cliente();
				cliente.setIdCliente(resultSet.getLong(1));
				cliente.setNmCliente(resultSet.getString(2));
				cliente.setNrCpf(resultSet.getString(3));
				lista.add(cliente);
			}
		} catch(SQLException e){
			throw e;
		}
		return lista;
	}
}
