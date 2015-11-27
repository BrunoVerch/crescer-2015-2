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

    public List<Cliente> findByName(String nome) {
        return em.createQuery("FROM Cliente c WHERE c.nome LIKE :nome", Cliente.class)
                .setParameter("nome", nome + "%")
                .getResultList();
    }

    public List<Cliente> findBySituacao(SituacaoCliente situacao) {
        return em.createQuery("FROM Cliente c WHERE c.situacao = :situacao", Cliente.class)
                .setParameter("situacao", situacao)
                .getResultList();
    }

    public List<Cliente> findAll() {
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class)
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

    @Transactional
    public void exclude(Cliente cliente){
        em.remove(em.getReference(Cliente.class, cliente.getIdCliente()));
    }

}
