package com.classe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Professeur {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    @Column(length=100)
	private String nom ;
    @Column(length=100)
	private String matiere;
	
	
	public Professeur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Professeur(String nom, String matiere) {
		super();
		this.nom = nom;
		this.matiere = matiere;
	}
	public int getId() {
		return id;
	}
	public void setId(int l) {
		this.id = l;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	
	
	
}
