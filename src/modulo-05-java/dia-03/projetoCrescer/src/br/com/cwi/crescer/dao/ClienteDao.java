package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Cliente;

public class ClienteDao {

    public void insert(Cliente cliente) throws SQLException{
        try(Connection conexao = new ConnectionFactory().getConnection()){

            PreparedStatement statement = conexao.prepareStatement("INSERT INTO cliente (idCliente,nmCliente,nrCpf) VALUES (cliente_seq.nextVal,?,?)");
            statement.setString(1, cliente.getNmCliente());
            statement.setString(2, cliente.getNrCpf());
            statement.execute();

            /*Statement stmt = conexao.createStatement();
			stmt.execute(" INSERT INTO cliente (idCliente,nmCliente,nrCpf) VALUES ("+cliente.getIdCliente()+", '" + cliente.getNmCliente()+"', '"+cliente.getNrCpf()+"') ");
			stmt.close();*/

        } catch(SQLException e){
            throw e;
        }
    }

    public void delete(Long idCliente) throws SQLException {
        try (Connection conexao = ConnectionFactory.getConnection()) {
            PreparedStatement statement = conexao.prepareStatement("delete from cliente where idCliente = ?");
            statement.setLong(1, idCliente);
            statement.execute();

        } catch (SQLException e) {
            throw e;
        }
    }

    public void update(Cliente cliente) throws SQLException {
        try (Connection conexao = ConnectionFactory.getConnection()) {
            PreparedStatement statement = conexao.prepareStatement("update cliente set nmCliente = ?,nrCpf = ? where idCliente = ?");
            statement.setString(1, cliente.getNmCliente());
            statement.setString(2, cliente.getNrCpf());
            statement.setLong(3, cliente.getIdCliente());
            statement.execute();

        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Cliente> find(Cliente cliente) throws SQLException {
        try (Connection conexao = ConnectionFactory.getConnection()) {
            List<Cliente> lista = new ArrayList<Cliente>();

            StringBuilder sql = new StringBuilder();
            sql.append("select idCliente,nmCliente,nrCpf from cliente where 1 = 1");

            List<Object> parameters = new ArrayList<Object>();
            if (cliente.getIdCliente() != null) {
                sql.append(" and idCliente = ?");
                parameters.add(cliente.getIdCliente());
            }
            if (cliente.getNmCliente() != null) {
                sql.append(" and nmCliente = ?");
                parameters.add(cliente.getNmCliente());
            }
            if (cliente.getNrCpf() != null) {
                sql.append(" and nrCpf = ?");
                parameters.add(cliente.getNrCpf());
            }

            PreparedStatement statement = conexao.prepareStatement(sql.toString());

            for (int i = 0; i < parameters.size(); i++) {
                statement.setObject(i + 1, parameters.get(i));
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Cliente cliente1 = new Cliente();
                cliente1.setIdCliente(resultSet.getLong(1));
                cliente1.setNmCliente(resultSet.getString(2));
                cliente1.setNrCpf(resultSet.getString(3));
                lista.add(cliente1);
            }

            return lista;
        } catch (SQLException e) {
            throw e;
        }
    }

    public Cliente load(Long idCliente) throws SQLException {
        try (Connection conexao = ConnectionFactory.getConnection()) {
            Cliente cliente = new Cliente();

            PreparedStatement statement = conexao.prepareStatement("select idCliente,nmCliente,nrCpf from cliente where idCliente = ?");
            statement.setLong(1, idCliente);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                cliente.setIdCliente(resultSet.getLong(1));
                cliente.setNmCliente(resultSet.getString(2));
                cliente.setNrCpf(resultSet.getString(3));
            } else {
                throw new RuntimeException("Cliente não encontrado");
            }

            return cliente;
        } catch (SQLException e) {
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
