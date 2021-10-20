package it.epicode.be.gestioneeventi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "partecipazione")
@NamedQuery(name = "partecipazioniDaConfermare", query = "select c from Partecipazione c where c.stato in :listaPart")


public class Partecipazione {
	
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "be_partecipazione_seq", sequenceName = "be_partecipazione_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "be_partecipazione_seq" )
	private Long id;
	

	@ManyToOne
	private Persona pers;

	
	@ManyToOne
	private Evento ev;

	
	@Enumerated(EnumType.STRING)
	@Column(name = "stato")
	private Stato stato;

	

	public Partecipazione() {

	}

	public Partecipazione(Long id, Persona pers, Evento ev, Stato stato) {
		super();
		this.id = id;
		this.pers = pers;
		this.ev = ev;
		this.stato = stato;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Persona getPers() {
		return pers;
	}

	public void setPers(Persona pers) {
		this.pers = pers;
	}

	public Evento getEv() {
		return ev;
	}

	public void setEv(Evento ev) {
		this.ev = ev;
	}

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	@Override
	public String toString() {
		return "Partecipazione [id=" + id + ", pers=" + pers + ", ev=" + ev + ", stato=" + stato + "]";
	}

}
