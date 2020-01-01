package com.ensa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;


@Entity
public class Professeur implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String username;
	private String password;
	private String nom;
	private String prenom;
	private String email;
	private Long tel;
	@OneToMany(mappedBy = "professeur")
	private Collection<Absence> absences;
	
	public Professeur() {
		super();
		absences = new ArrayList<>();
	}


	public Professeur(Long id, String username, String password, String nom, String prenom, String email, Long tel,
			Collection<Absence> absences) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.absences = absences;
	}



	public Professeur(String username, String password, String nom, String prenom, String email, Long tel,
			Collection<Absence> absences) {
		super();
		this.username = username;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.absences = absences;
	}


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
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



	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Long getTel() {
		return tel;
	}


	public void setTel(Long tel) {
		this.tel = tel;
	}


	public User toUser() {
		return new User(this.getUsername(),this.getPassword(),Role.PROF);
	}
	
}
