package it.epicode.be.gestioneeventi.main;

import java.util.Date;

import java.util.GregorianCalendar;
import java.util.List;

import it.epicode.be.gestioneeventi.model.Concerto;
import it.epicode.be.gestioneeventi.model.Evento;
import it.epicode.be.gestioneeventi.model.GaraDiAtletica;
import it.epicode.be.gestioneeventi.model.GenereConcerto;
import it.epicode.be.gestioneeventi.model.Location;
import it.epicode.be.gestioneeventi.model.Partecipazione;
import it.epicode.be.gestioneeventi.model.PartitaDiCalcio;
import it.epicode.be.gestioneeventi.model.Persona;
import it.epicode.be.gestioneeventi.model.Sesso;
import it.epicode.be.gestioneeventi.model.Stato;
import it.epicode.be.gestioneeventi.model.TipoEvento;
import it.epicode.be.gestioneeventi.model.dao.EventoDAO;
import it.epicode.be.gestioneeventi.model.dao.LocationDAO;
import it.epicode.be.gestioneeventi.model.dao.PartecipazioneDAO;
import it.epicode.be.gestioneeventi.model.dao.PersonaDAO;

public class Main {

	public static void main(String[] args) {
		Main e = new Main();
		e.esegui();

	}

	private void esegui() {

		// POPOLA

		PartecipazioneDAO pDAO = new PartecipazioneDAO();
		EventoDAO eDao = new EventoDAO();
		LocationDAO ldao = new LocationDAO();
		PersonaDAO pDao = new PersonaDAO();

		// Location
		Location l1 = new Location(null, "location1", "roma");
		ldao.save(l1);

		Location l2 = new Location(null, "location2", "bari");
		ldao.save(l2);

		Location l3 = new Location(null, "location3", "milano");
		ldao.save(l3);

		// Persona

		Persona p1 = new Persona(null, "christian", "niro", "christian@gmail.com",
				new GregorianCalendar(1994, 9, 21).getTime(), Sesso.MASCHIO);
		pDao.save(p1);

		Persona p2 = new Persona(null, "francesca", "derosa", "francesca@gmail.com",
				new GregorianCalendar(1992, 8, 23).getTime(), Sesso.FEMMINA);
		pDao.save(p2);

		// Evento

		Evento e1 = new Evento(null, "Vaccini", "pfizer", TipoEvento.PRIVATO, 10, new Date(), l1);
		eDao.save(e1);

		Evento e2 = new Evento(null, "Torneo", "Carte", TipoEvento.PUBBLICO, 100, new Date(), l2);
		eDao.save(e2);

		// Cerca Evento per Descrizione

		List<Evento> lista = eDao.selEvFromDescr();
		for (Evento e : lista) {
			System.out.println("*****************************");
			System.out.println("Cerca Evento Per Descrizione*");
			System.out.println("*****************************");

			System.out.println(e.toString());
		}

		// Partecipazione

		Partecipazione par1 = new Partecipazione(null, p1, e1, Stato.DA_CONFERMARE);
		pDAO.save(par1);

		Partecipazione par2 = new Partecipazione(null, p2, e2, Stato.CONFERMATA);
		pDAO.save(par2);

		// Cerca Partecipanti per Stato

		List<Partecipazione> lst6 = pDAO.getPartecipazioneDaConfermarePerEvento(Stato.DA_CONFERMARE);
		for (Partecipazione c : lst6) {
			System.out.println("********************************");
			System.out.println("Lista Partecipanti Da Confermare");
			System.out.println("********************************");

			System.out.println(c.toString());
		}

		// PartitaDiCalcio

		PartitaDiCalcio part = new PartitaDiCalcio(null, "PartitaDiCalcio", "Champions", TipoEvento.PUBBLICO, 100,
				new Date(), l3, "Inter", "Barcellona", "Barcellona", 1, 2);
		eDao.save(part);

		PartitaDiCalcio part2 = new PartitaDiCalcio(null, "PartitaDiCalcio", "Mondiale", TipoEvento.PUBBLICO, 1000,
				new Date(), l2, "Italia", "Francia", "Italia", 4, 2);
		eDao.save(part2);

		PartitaDiCalcio part3 = new PartitaDiCalcio(null, "PartitaDiCalcio", "Amichevole", TipoEvento.PUBBLICO, 100,
				new Date(), l1, "Juventus", "Fiorentina", null, 1, 1);
		eDao.save(part3);

		List<PartitaDiCalcio> lst = eDao.getPartiteVinteInCasa();
		for (PartitaDiCalcio p : lst) {
			System.out.println("*****************************");
			System.out.println("Cerca Partite VinteInCasa*");
			System.out.println("*****************************");

			System.out.println(p.toString());
		}

		List<PartitaDiCalcio> lst2 = eDao.getPartiteVinteInTrasferta();
		for (PartitaDiCalcio p : lst2) {
			System.out.println("*******************************");
			System.out.println("Cerca Partite VinteInTrasferta*");
			System.out.println("*******************************");

			System.out.println(p.toString());
		}

		List<PartitaDiCalcio> lst3 = eDao.getPartitePareggiate();
		for (PartitaDiCalcio p : lst3) {
			System.out.println("*************************");
			System.out.println("Cerca Partite Pareggiate*");
			System.out.println("*************************");

			System.out.println(p.toString());
		}

		// GaraDiAtletica

		GaraDiAtletica gar = new GaraDiAtletica(null, "GaraDiAtletica", "SaltoInAlto", TipoEvento.PUBBLICO, 1000,
				new Date(), l1, p2, null);
		eDao.save(gar);

		GaraDiAtletica gar2 = new GaraDiAtletica(null, "GaraDiAtletica", "CorsaOstacoli", TipoEvento.PUBBLICO, 1000,
				new Date(), l2, p1, null);
		eDao.save(gar2);

		// Cerca Gara di Atletica per Vincitore

		List<GaraDiAtletica> lst7 = eDao.getGareDiAtleticaPerVincitore(p2);
		for (GaraDiAtletica c : lst7) {
			System.out.println("***********************************");
			System.out.println("Lista Gara Di Atletica Per Vincitore");
			System.out.println("***********************************");

			System.out.println(c.toString());
		}

		// Concerto

		Concerto con = new Concerto(null, "Concerto", "musica pop", TipoEvento.PUBBLICO, 100, new Date(), l1,
				GenereConcerto.POP, true);
		eDao.save(con);

		Concerto con2 = new Concerto(null, "Concerto", "musica rock", TipoEvento.PUBBLICO, 100, new Date(), l3,
				GenereConcerto.ROCK, false);
		eDao.save(con2);

		// Cerca Concerti in Streaming

		List<Concerto> lst4 = eDao.getConcertiInStreaming(true);
		for (Concerto c : lst4) {
			System.out.println("*********************");
			System.out.println("Concerti in Streaming");
			System.out.println("*********************");

			System.out.println(c.toString());
		}

		// Cerca Concerti per Genere

		List<Concerto> lst5 = eDao.getConcertiPerGenere(GenereConcerto.POP);
		for (Concerto c : lst5) {
			System.out.println("*******************");
			System.out.println("Concerti per Genere");
			System.out.println("*******************");

			System.out.println(c.toString());
		}

	}

}
