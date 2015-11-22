package br.com.cwi.crescer.lavanderia.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Item;

@Repository
public class ItemDAO {

	@PersistenceContext
	private EntityManager em;

	public Item findById(Long id) {
		return em.find(Item.class, id);
	}
}
