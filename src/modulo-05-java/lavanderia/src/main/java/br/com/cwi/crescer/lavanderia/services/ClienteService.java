package br.com.cwi.crescer.lavanderia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.DAO.ClienteDAO;
import br.com.cwi.crescer.lavanderia.domain.Cliente;

@Service
public class ClienteService {

	private ClienteDAO clienteDao;
	
	@Autowired
	public ClienteService(ClienteDAO clienteDao){
		super();
		this.clienteDao = clienteDao;
	}
	
	public Cliente findById(Long id){
		return this.clienteDao.findById(id);
	}
}
