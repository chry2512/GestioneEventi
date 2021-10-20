package it.epicode.be.gestioneeventi.model.dao;

import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;

import it.epicode.be.gestioneeventi.model.Persona;
import it.epicode.be.gestioneeventi.util.JpaUtil;


public class PersonaDAO {
	
	
	public void save(Persona p) {
		
		EntityManager em = JpaUtil.getEntitymanagerfactory().createEntityManager();

		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(p);
			transaction.commit();

		} finally {

			em.close();

		}

	}

	public Persona getById(Long id) {
		EntityManager em = JpaUtil.getEntitymanagerfactory().createEntityManager();
		
        try {
        	
        	Persona p = em.find(Persona.class, id);
        	return p;
			
		} finally {
			
			em.close();

		}
		
		
	

	}

	public void delete(Persona p) {
		EntityManager em = JpaUtil.getEntitymanagerfactory().createEntityManager();

		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(p);
			transaction.commit();

		} finally {

			em.close();
		}

	}

	public void refresh(Persona p) {
		EntityManager em = JpaUtil.getEntitymanagerfactory().createEntityManager();

		try {

			em.refresh(p);

		} finally {
			em.close();

		}

	}

}
