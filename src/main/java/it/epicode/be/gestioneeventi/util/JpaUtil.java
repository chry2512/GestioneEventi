package it.epicode.be.gestioneeventi.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static final EntityManagerFactory entityManagerFactory;

	static {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("GestioneEventi");

		} catch (Throwable e) {
			System.err.println("Initial EntityManagerFactory creation failed." + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static EntityManagerFactory getEntitymanagerfactory() {
		return entityManagerFactory;
	}

}
