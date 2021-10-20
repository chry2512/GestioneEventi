package it.epicode.be.gestioneeventi.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.epicode.be.gestioneeventi.model.Concerto;
import it.epicode.be.gestioneeventi.model.Evento;
import it.epicode.be.gestioneeventi.model.GaraDiAtletica;
import it.epicode.be.gestioneeventi.model.GenereConcerto;
import it.epicode.be.gestioneeventi.model.PartitaDiCalcio;
import it.epicode.be.gestioneeventi.model.Persona;
import it.epicode.be.gestioneeventi.util.JpaUtil;

public class EventoDAO {

	// Generic
	public void save(Evento e) {
		EntityManager em = JpaUtil.getEntitymanagerfactory().createEntityManager();

		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(e);
			transaction.commit();

		} finally {

			em.close();

		}

	}

	public Evento getById(Long id) {

		EntityManager em = JpaUtil.getEntitymanagerfactory().createEntityManager();
		try {

			Evento e1 = em.find(Evento.class, id);
			return e1;

		} finally {
			em.close();
		}

	}

	public void delete(Evento e) {
		EntityManager em = JpaUtil.getEntitymanagerfactory().createEntityManager();

		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(e);
			transaction.commit();

		} finally {

			em.close();
		}

	}

	public void refresh(Evento e) {
		EntityManager em = JpaUtil.getEntitymanagerfactory().createEntityManager();

		try {

			em.refresh(e);

		} finally {
			em.close();

		}

	}

	// Cerca per Descrizione

	public List<Evento> selEvFromDescr() {

		EntityManager em = JpaUtil.getEntitymanagerfactory().createEntityManager();
		try {
			Query query = em.createNamedQuery("eventoDaDescrizione");
			query.setParameter("descr", "pfizer%");
			// query.getSingleResult();

			List<Evento> lst = query.getResultList();

			return lst;

		} finally {

			em.close();

		}

	}

	// Cerca per Concerti in Streaming
	public List<Concerto> getConcertiInStreaming(Boolean inStreaming) {
		EntityManager em = JpaUtil.getEntitymanagerfactory().createEntityManager();
		try {
			Query query = em.createNamedQuery("concertiInStreaming");
			query.setParameter("streaming", inStreaming);
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	// Cerca Conccerto per Genere
	public List<Concerto> getConcertiPerGenere(GenereConcerto pop) {
		EntityManager em = JpaUtil.getEntitymanagerfactory().createEntityManager();
		try {
			Query query = em.createNamedQuery("concertiPerGenere");
			query.setParameter("listagenere", pop);
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	// Cerca partite Vinte in Casa

	public List<PartitaDiCalcio> getPartiteVinteInCasa() {

		EntityManager em = JpaUtil.getEntitymanagerfactory().createEntityManager();
		try {
			Query query = em.createNamedQuery("PartiteVinteInCasa");
			List<PartitaDiCalcio> lst = query.getResultList();

			return lst;

		} finally {

			em.close();

		}

	}

	// Cerca Partite Vinte in Trasferta

	public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {

		EntityManager em = JpaUtil.getEntitymanagerfactory().createEntityManager();
		try {
			Query query = em.createNamedQuery("PartiteVinteInTrasferta");
			List<PartitaDiCalcio> lst = query.getResultList();

			return lst;

		} finally {

			em.close();

		}

	}

	// Cerca Partite Pareggiate

	public List<PartitaDiCalcio> getPartitePareggiate() {

		EntityManager em = JpaUtil.getEntitymanagerfactory().createEntityManager();
		try {

			Query query = em.createNamedQuery("PartitePareggiate");
			List<PartitaDiCalcio> lst = query.getResultList();

			return lst;

		} finally {

			em.close();

		}

	}

	// Cerca Gare di Atletica per Vincitore

	public List<GaraDiAtletica> getGareDiAtleticaPerVincitore(Persona vincitore) {
		EntityManager em = JpaUtil.getEntitymanagerfactory().createEntityManager();
		try {
			Query query = em.createNamedQuery("garaDiAtleticaVincitore");
			query.setParameter("listaWin", vincitore);
			return query.getResultList();
		} finally {
			em.close();
		}
	}

}
