package br.com.crescer.lavanderia.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Produto;

@Repository
public class ProdutoDAO {

	@PersistenceContext
	private EntityManager em;

	public Produto findById(Long id) {
		return em.find(Produto.class, id);
	}
}
