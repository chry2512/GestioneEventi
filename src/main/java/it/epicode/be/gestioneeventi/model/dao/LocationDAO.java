package it.epicode.be.gestioneeventi.model.dao;

import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;

import it.epicode.be.gestioneeventi.model.Location;
import it.epicode.be.gestioneeventi.util.JpaUtil;



public class LocationDAO {

	public void save(Location l) {

		EntityManager em = JpaUtil.getEntitymanagerfactory().createEntityManager();

		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(l);
			transaction.commit();

		} finally {

			em.close();

		}

	}

	public Location getById(Long id) {
		EntityManager em = JpaUtil.getEntitymanagerfactory().createEntityManager();

		try {

			Location l = em.find(Location.class, id);
			return l;

		} finally {

			em.close();

		}

	}

	public void delete(Location l) {
		EntityManager em = JpaUtil.getEntitymanagerfactory().createEntityManager();

		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(l);
			transaction.commit();

		} finally {

			em.close();
		}

	}

	public void refresh(Location l) {
		EntityManager em = JpaUtil.getEntitymanagerfactory().createEntityManager();

		try {

			em.refresh(l);

		} finally {
			em.close();

		}

	}

}
