package it.epicode.be.gestioneeventi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "concertiInStreaming", query = "select c from Concerto c where c.inStreaming = :streaming")
@NamedQuery(name = "concertiPerGenere", query = "select c from Concerto c where c.genere in :listagenere")
public class Concerto extends Evento {

	@Enumerated(EnumType.STRING)
	private GenereConcerto genere;

	private Boolean inStreaming;

	public Concerto() {
		super();

	}

	public Concerto(Long id, String titolo, String descrizione, TipoEvento tipoEvento,
			Integer numeroMassimoPartecipanti, Date dataEvento, Location location,GenereConcerto genere, Boolean inStreaming) {
		super(id, titolo, descrizione, tipoEvento, numeroMassimoPartecipanti, dataEvento, location);
		this.genere = genere;
		this.inStreaming = inStreaming;

	}

	@Override
	public String toString() {
		return "Concerto [genere=" + genere + ", inStreaming=" + inStreaming + "]";
	}

	public Boolean getInStreaming() {
		return inStreaming;
	}

	public void setInStreaming(Boolean inStreaming) {
		this.inStreaming = inStreaming;
	}

	public GenereConcerto getGenere() {
		return genere;
	}

	public void setGenere(GenereConcerto genere) {
		this.genere = genere;
	}

}
