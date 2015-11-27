package br.com.cwi.crescer.lavanderia.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cwi.crescer.lavanderia.domain.Users;
import br.com.cwi.crescer.lavanderia.domain.Users.EnableUser;


@Repository
public class UsersDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Users findByUsername(String username) {
        return em.find(Users.class, username);
    }
	
	public List<Users> findByEnables(EnableUser enabled) {
        return em.createQuery("SELECT c FROM Users c WHERE c.enabled = :enabled", Users.class)
                .setParameter("enabled", enabled)
                .getResultList();
    }
	
	public List<Users> findAll() {
        return em.createQuery("SELECT c FROM Users c", Users.class)
                .getResultList();
    }

    @Transactional
    public Users save(Users users) {
        em.merge(users);
        return users;
    }
    
    @Transactional
    public Users create(Users users){
    	em.persist(users);
    	return users;
    }
}
