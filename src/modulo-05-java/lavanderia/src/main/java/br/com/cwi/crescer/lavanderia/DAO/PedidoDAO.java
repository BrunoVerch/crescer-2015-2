package br.com.cwi.crescer.lavanderia.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Pedido.SituacaoPedido;

@Repository
public class PedidoDAO {

    @PersistenceContext
    private EntityManager em;

    public Pedido findById(Long id) {
        return em.find(Pedido.class, id);
    }

    public List<Pedido> findBySituacao(SituacaoPedido situacao) {
        return em.createQuery("FROM Pedido c WHERE c.situacao = :situacao", Pedido.class)
                .setParameter("situacao", situacao)
                .getResultList();
    }

    public List<Pedido> findAll() {
        return em.createQuery("SELECT c FROM Pedido c", Pedido.class)
                .getResultList();
    }

    @Transactional
    public Pedido save(Pedido pedido) {
        if (pedido.getIdPedido() == null) {
            em.persist(pedido);
            return pedido;
        }
        em.merge(pedido);
        return pedido;
    }
}
