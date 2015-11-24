package br.com.cwi.crescer.lavanderia.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Cliente.SituacaoCliente;

@Repository
public class ClienteDAO {

    @PersistenceContext
    private EntityManager em;

    public Cliente findById(Long id) {
        return em.find(Cliente.class, id);
    }

    public List<Cliente> findBySituacao(SituacaoCliente situacao) {
        return em.createQuery("FROM Cliente c WHERE c.situacao = :situacao", Cliente.class)
                .setParameter("situacao", situacao)
                .getResultList();
    }

    @Transactional
    public Cliente save(Cliente cliente) {
        if (cliente.getIdCliente() == null) {
            em.persist(cliente);
            return cliente;
        }
        em.merge(cliente);
        return cliente;
    }
}
