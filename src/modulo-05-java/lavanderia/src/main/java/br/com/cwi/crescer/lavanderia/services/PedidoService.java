package br.com.cwi.crescer.lavanderia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.DAO.PedidoDAO;
import br.com.cwi.crescer.lavanderia.domain.Pedido;

@Service
public class PedidoService {

	private PedidoDAO pedidoDao;
	
	@Autowired
	public PedidoService(PedidoDAO pedidoDao){
		super();
		this.pedidoDao = pedidoDao;
	}
	
	public Pedido findById(Long id){
		return this.pedidoDao.findById(id);
	}
}
