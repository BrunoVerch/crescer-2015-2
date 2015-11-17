package br.com.cwi.crescer;

import java.sql.SQLException;
import java.util.List;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.model.Cliente;

public class AplicacaoDao {

	public static void main(String[] args) throws SQLException {
		ClienteDao dao = new ClienteDao();
		List<Cliente> lista = dao.listAll();
		for (Cliente cliente : lista) {
			System.out.println(cliente.getNmCliente());
		}
	}

}
