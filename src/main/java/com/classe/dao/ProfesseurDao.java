package com.classe.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.classe.model.Professeur;

@Repository
public interface ProfesseurDao extends CrudRepository<Professeur,Integer>{
		
	List <Professeur> findAll();
	Professeur save (Professeur professeur) ;
	void delete (int id);
	//public  Professeur findAllByProfesseurNom (String nom);
	Professeur findOne(int id);
	Professeur findProfesseurById(int id);

}

