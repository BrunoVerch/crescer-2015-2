package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Pedido;

public class PedidoDao {

    public void include(Pedido pedido) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            PreparedStatement statement = conexao.prepareStatement("INSERT INTO pedido (idPedido,idCliente,dsPedido) VALUES (pedido_seq.nextVal,?,?)");
            statement.setLong(1, pedido.getIdCliente());
            statement.setString(2, pedido.getDsPedido());
            statement.execute();

        } catch (SQLException e) {
            throw e;
        }
    }

    public void update(Pedido pedido) throws SQLException {
        try (Connection conexao = ConnectionFactory.getConnection()) {
            PreparedStatement statement = conexao.prepareStatement("update pedido set idCliente = ?,dsPedido = ? where idPedido = ?");
            statement.setLong(1, pedido.getIdCliente());
            statement.setString(2, pedido.getDsPedido());
            statement.setLong(3, pedido.getIdPedido());
            statement.execute();

        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Pedido> find(Pedido pedido) throws SQLException {
        try (Connection conexao = ConnectionFactory.getConnection()) {
            List<Pedido> lista = new ArrayList<Pedido>();

            StringBuilder sql = new StringBuilder();
            sql.append("select idPedido,idCliente,dsPedido from pedido where 1 = 1");

            List<Object> parameters = new ArrayList<Object>();
            if (pedido.getIdPedido() != null) {
                sql.append(" and idPedido = ?");
                parameters.add(pedido.getIdPedido());
            }
            if (pedido.getIdCliente() != null) {
                sql.append(" and idCliente = ?");
                parameters.add(pedido.getIdCliente());
            }
            if (pedido.getDsPedido() != null) {
                sql.append(" and dsPedido = ?");
                parameters.add(pedido.getDsPedido());
            }

            PreparedStatement statement = conexao.prepareStatement(sql.toString());

            for (int i = 0; i < parameters.size(); i++) {
                statement.setObject(i + 1, parameters.get(i));
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Pedido pedido1 = new Pedido();
                pedido1.setIdPedido(resultSet.getLong(1));
                pedido1.setIdCliente(resultSet.getLong(2));
                pedido1.setDsPedido(resultSet.getString(3));
                lista.add(pedido1);
            }

            return lista;
        } catch (SQLException e) {
            throw e;
        }
    }
}
