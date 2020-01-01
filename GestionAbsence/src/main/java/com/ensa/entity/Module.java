package com.ensa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Module implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id_module;
	private String libelle;
	private int chargeHoraire;
	@OneToMany(mappedBy = "module")
	private Collection<Absence> absences;
	
	public Module() {
		super();
		absences = new ArrayList<>();
	}

	

	public Module(Long id_module, String libelle, int chargeHoraire,
			Collection<Absence> absences) {
		super();
		this.id_module = id_module;
		this.libelle = libelle;
		this.chargeHoraire = chargeHoraire;
		this.absences = absences;
	}



	public Module(String libelle, int chargeHoraire, Collection<Absence> absences) {
		super();
		this.libelle = libelle;
		this.chargeHoraire = chargeHoraire;
		this.absences = absences;
	}



	public Long getId_module() {
		return id_module;
	}



	public void setId_module(Long id_module) {
		this.id_module = id_module;
	}



	public String getLibelle() {
		return libelle;
	}



	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	public int getChargeHoraire() {
		return chargeHoraire;
	}



	public void setChargeHoraire(int chargeHoraire) {
		this.chargeHoraire = chargeHoraire;
	}



	public Collection<Absence> getAbsences() {
		return absences;
	}



	public void setAbsences(Collection<Absence> absences) {
		this.absences = absences;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}
