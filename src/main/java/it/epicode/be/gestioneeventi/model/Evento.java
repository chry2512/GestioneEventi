package it.epicode.be.gestioneeventi.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "evento")
@NamedQuery(name = "eventoDaDescrizione", query = "select e from Evento e where e.descrizione like :descr")

public class Evento {

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "be_evento_seq", sequenceName = "be_evento_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "be_evento_seq")
	private Long id;

	@Column(name = "titolo")
	private String titolo;

	@Column(name = "descrizione")
	private String descrizione;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipoEvento")
	private TipoEvento tipoEvento;

	@Column(name = "numeroMassimoPartecipanti")
	private Integer numeroMassimoPartecipanti;

	@Column(name = "dataEvento")
	private Date dataEvento;

	@OneToMany(mappedBy = "ev", cascade = CascadeType.REMOVE)
	private Set<Partecipazione> setPart = new HashSet<>();

	@OneToOne
	private Location location;

	public Evento() {

	}

	public Evento(Long id, String titolo, String descrizione, TipoEvento tipoEvento, Integer numeroMassimoPartecipanti,
			Date dataEvento, Location location) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
		this.dataEvento = dataEvento;
		this.location = location;

	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", titolo=" + titolo + ", descrizione=" + descrizione + ", tipoEvento=" + tipoEvento
				+ ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti + ", dataEvento=" + dataEvento
				+ ", location=" + location + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public Integer getNumeroMassimoPartecipanti() {
		return numeroMassimoPartecipanti;
	}

	public void setNumeroMassimoPartecipanti(Integer numeroMassimoPartecipanti) {
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public Set<Partecipazione> getSetPartecipazioni() {
		return setPart;
	}

	public void setSetPartecipazioni(Set<Partecipazione> setPartecipazioni) {
		this.setPart = setPartecipazioni;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
