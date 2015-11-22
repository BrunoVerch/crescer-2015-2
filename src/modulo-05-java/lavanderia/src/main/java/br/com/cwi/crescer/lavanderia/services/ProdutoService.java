package br.com.cwi.crescer.lavanderia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.DAO.ProdutoDAO;
import br.com.cwi.crescer.lavanderia.domain.Produto;

@Service
public class ProdutoService {

	private ProdutoDAO produtoDao;
	
	@Autowired
	public ProdutoService(ProdutoDAO produtoDao){
		super();
		this.produtoDao = produtoDao;
	}
	
	public Produto findById(Long id){
		return this.produtoDao.findById(id);
	}
}
