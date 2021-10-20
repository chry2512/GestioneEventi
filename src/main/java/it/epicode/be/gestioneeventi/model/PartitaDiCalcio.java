package it.epicode.be.gestioneeventi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = "PartiteVinteInTrasferta", query = "select p from PartitaDiCalcio p where p.squadraOspite = p.squadraVincente")
@NamedQuery(name = "PartiteVinteInCasa", query = "select p from PartitaDiCalcio p where p.squadraDiCasa = p.squadraVincente")
@NamedQuery(name = "PartitePareggiate", query = "select p from PartitaDiCalcio p where p.numGolCasa = p.numGolOspite")

//Oppure con is Null @NamedQuery(name = "PartitePareggiate", query = "select p from PartitaDiCalcio p where p.squadraVincente is Null")

public class PartitaDiCalcio extends Evento {

	private String squadraDiCasa;
	private String squadraOspite;
	private String squadraVincente;
	private Integer numGolCasa = 0;
	private Integer numGolOspite = 0;
	
	
	public PartitaDiCalcio() {
		super();

	}

	public PartitaDiCalcio(Long id, String titolo, String descrizione, TipoEvento tipoEvento,
			Integer numeroMassimoPartecipanti, Date dataEvento, Location location, String squadraDiCasa, String squadraOspite,
			String squadraVincente, Integer numGolCasa, Integer numGolOspite) {
		super(id, titolo, descrizione, tipoEvento, numeroMassimoPartecipanti, dataEvento,location);

		this.squadraDiCasa = squadraDiCasa;
		this.squadraOspite = squadraOspite;
		this.squadraVincente = squadraVincente;
		this.numGolCasa = numGolCasa;
		this.numGolOspite = numGolOspite;

	}

	@Override
	public String toString() {
		return "PartitaDiCalcio [squadraDiCasa=" + squadraDiCasa + ", squadraOspite=" + squadraOspite
				+ ", squadraVincente=" + squadraVincente + ", numGolCasa=" + numGolCasa + ", numGolOspite="
				+ numGolOspite + "]";
	}

	public String getSquadraDiCasa() {
		return squadraDiCasa;
	}

	public void setSquadraDiCasa(String squadraDiCasa) {
		this.squadraDiCasa = squadraDiCasa;
	}

	public String getSquadraOspite() {
		return squadraOspite;
	}

	public void setSquadraOspite(String squadraOspite) {
		this.squadraOspite = squadraOspite;
	}

	public String getSquadraVincente() {
		return squadraVincente;
	}

	public void setSquadraVincente(String squadraVincente) {
		this.squadraVincente = squadraVincente;
	}

	public Integer getNumGolCasa() {
		return numGolCasa;
	}

	public void setNumGolCasa(Integer numGolCasa) {
		this.numGolCasa = numGolCasa;
	}

	public Integer getNumGolOspite() {
		return numGolOspite;
	}

	public void setNumGolOspite(Integer numGolOspite) {
		this.numGolOspite = numGolOspite;
	}

}
