package it.epicode.be.gestioneeventi.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "garaDiAtleticaVincitore", query = "select c from GaraDiAtletica c where c.vincitore in :listaWin")


public class GaraDiAtletica extends Evento {

	@ManyToMany
	private Set<Persona> setAtleti;

	@ManyToOne
	private Persona vincitore;

	public GaraDiAtletica() {
		super();

	}

	public GaraDiAtletica(Long id, String titolo, String descrizione, TipoEvento tipoEvento,
			Integer numeroMassimoPartecipanti, Date dataEvento, Location location, Persona vincitore,
			Set<Persona> setAtleti) {
		super(id, titolo, descrizione, tipoEvento, numeroMassimoPartecipanti, dataEvento, location);
		this.vincitore = vincitore;
		this.setAtleti = setAtleti;

	}

	@Override
	public String toString() {
		return "GaraDiAtletica [vincitore=" + vincitore + "]";
	}

	public Set<Persona> getSetAtleti() {
		return setAtleti;
	}

	public void setSetAtleti(Set<Persona> setAtleti) {
		this.setAtleti = setAtleti;
	}

	public Persona getVincitore() {
		return vincitore;
	}

	public void setVincitore(Persona vincitore) {
		this.vincitore = vincitore;
	}

}
