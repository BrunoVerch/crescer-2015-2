package br.com.cwi.crescer.lavanderia.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cwi.crescer.lavanderia.domain.Produto;

@Repository
public class ProdutoDAO {

    @PersistenceContext
    private EntityManager em;

    public Produto findById(Long id) {
        return em.find(Produto.class, id);
    }

    public List<Produto> findAll() {
        return em.createQuery("SELECT c FROM Produto c", Produto.class)
                .getResultList();
    }
    
    public Produto findByServicoAndMaterial(Long idServico,Long idMaterial){
    	return em.createQuery("FROM Produto p WHERE idServico = :idServico AND idMaterial = :idMaterial", Produto.class)
    			.setParameter("idServico", idServico)
    			.setParameter("idMaterial", idMaterial)
    			.getSingleResult();
    }

    @Transactional
    public Produto save(Produto produto) {
        if (produto.getIdProduto() == null) {
            em.persist(produto);
            return produto;
        }
        em.merge(produto);
        return produto;
    }
}
