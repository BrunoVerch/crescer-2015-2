package br.com.cwi.crescer.lavanderia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.DAO.ServicoDAO;
import br.com.cwi.crescer.lavanderia.domain.Servico;

@Service
public class ServicoService {

	private ServicoDAO servicoDao;
	
	@Autowired
	public ServicoService(ServicoDAO servicoDao){
		super();
		this.servicoDao = servicoDao;
	}
	
	public Servico findById(Long id){
		return this.servicoDao.findById(id);
	}
}
