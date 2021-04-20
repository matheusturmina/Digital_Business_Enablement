package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Usuario;
import br.com.fiap.util.EntityManagerFacade;

public class UsuarioDao {
	
	private EntityManager em = EntityManagerFacade.get();
	
	public void save(Usuario usuario) {
		try {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		em.close();
	}
	
	public List<Usuario> getAll(){
		String jpql = "SELECT s FROM Usuario s";
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		return query.getResultList();
	}

}
