package br.com.cwi.crescer.lavanderia.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Item.SituacaoItem;
import br.com.cwi.crescer.lavanderia.domain.Pedido;

@Repository
public class ItemDAO {

    @PersistenceContext
    private EntityManager em;

    public Item findById(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findBySituacao(SituacaoItem situacao) {
        return em.createQuery("FROM Item c WHERE c.situacao = :situacao", Item.class)
                .setParameter("situacao", situacao)
                .getResultList();
    }
    
    public List<Item> findByIdPedido(Pedido pedido){
    	return em.createQuery("FROM Item c WHERE c.pedido = :pedido", Item.class)
                .setParameter("pedido", pedido)
                .getResultList();
    }

    @Transactional
	public Item save(Item item) {	
		if (item.getIdItem() == null) {
            em.persist(item);
            return item;
        }
        return em.merge(item);
	}
}
