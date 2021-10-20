package it.epicode.be.gestioneeventi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "location")

public class Location  {
	@Id
	@Column(name = "id")
	@SequenceGenerator(name="be_location_seq", sequenceName="be_location_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="be_location_seq")
	private Long id;
	

	@Column(name = "nome")
	private String nome;
	

	@Column(name = "città")
	private String citta;

	public Location() {

	}

	public Location(Long id, String nome, String citta) {
		super();
		this.id = id;
		this.nome = nome;
		this.citta = citta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", nome=" + nome + ", citta=" + citta + "]";
	}

}
