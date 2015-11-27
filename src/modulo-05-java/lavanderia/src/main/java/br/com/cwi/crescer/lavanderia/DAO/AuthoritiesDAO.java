package br.com.cwi.crescer.lavanderia.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cwi.crescer.lavanderia.domain.Authorities;

@Repository
public class AuthoritiesDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Authorities findByUsername(String username) {
        return em.find(Authorities.class, username);
    }
	
	@Transactional
    public Authorities save(Authorities authorities) {
        em.merge(authorities);
        return authorities;
    }
    
    @Transactional
    public Authorities create(Authorities authorities){
    	em.persist(authorities);
    	return authorities;
    }
}
