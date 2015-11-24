package br.com.cwi.crescer.lavanderia.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Cidade;

@Repository
public class CidadeDAO {

    @PersistenceContext
    private EntityManager em;

    public Cidade findById(Long id) {
        return em.find(Cidade.class, id);
    }

    public List<Cidade> listAll() {
        return em.createQuery("FROM Cidade", Cidade.class)
                .getResultList();
    }
}
