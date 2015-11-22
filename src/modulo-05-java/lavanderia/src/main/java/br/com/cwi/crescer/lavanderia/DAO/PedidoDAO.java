package br.com.cwi.crescer.lavanderia.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Pedido;

@Repository
public class PedidoDAO {

	@PersistenceContext
	private EntityManager em;

	public Pedido findById(Long id) {
		return em.find(Pedido.class, id);
	}
}
