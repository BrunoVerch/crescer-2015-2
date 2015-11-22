package br.com.cwi.crescer.lavanderia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.DAO.CidadeDAO;
import br.com.cwi.crescer.lavanderia.domain.Cidade;

@Service
public class CidadeService {

	private CidadeDAO cidadeDao;
	
	@Autowired
	public CidadeService(CidadeDAO cidadeDao){
		super();
		this.cidadeDao = cidadeDao;
	}
	
	public Cidade findById(Long id){
		return this.cidadeDao.findById(id);
	}
}
