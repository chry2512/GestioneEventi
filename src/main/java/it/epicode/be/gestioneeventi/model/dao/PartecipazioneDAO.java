package it.epicode.be.gestioneeventi.model.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.epicode.be.gestioneeventi.model.Partecipazione;
import it.epicode.be.gestioneeventi.model.Stato;
import it.epicode.be.gestioneeventi.util.JpaUtil;


public class PartecipazioneDAO {

	
	public void save(Partecipazione p) {

		EntityManager em = JpaUtil.getEntitymanagerfactory().createEntityManager();

		EntityTransaction trans = em.getTransaction();
		trans.begin();
		em.persist(p);
		trans.commit();

		em.close();

	}

	public Partecipazione getById(Long id) {

		EntityManager em = JpaUtil.getEntitymanagerfactory().createEntityManager();

		try {

			Partecipazione p = em.find(Partecipazione.class, id);
			return p;

		} finally {

			em.close();

		}

	}

	public void delete(Partecipazione p) {

		EntityManager em = JpaUtil.getEntitymanagerfactory().createEntityManager();

		try {

			em.remove(p);

		} finally {

			em.close();

		}

	}

	public void refresh(Partecipazione p) {
		
		EntityManager em = JpaUtil.getEntitymanagerfactory().createEntityManager();

		try {
			
			em.refresh(p);
		

		} finally {
			
			em.close();

		}

	}
	
	public List<Partecipazione> getPartecipazioneDaConfermarePerEvento(Stato DA_CONFERMARE ) {
		EntityManager em = JpaUtil.getEntitymanagerfactory().createEntityManager();
		try {
			Query query = em.createNamedQuery("partecipazioniDaConfermare");
			query.setParameter("listaPart", DA_CONFERMARE);
			return query.getResultList();
		} finally {
			em.close();
		}
	}

}
