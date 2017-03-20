package com.classe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classe.dao.ProfesseurDao;
import com.classe.model.Professeur;


@Service
public class ProfesseurService {

	@Autowired
	private ProfesseurDao professeurDao;
			
	public ProfesseurDao getProfesseurDao() {
		return professeurDao;
	}

	public void setProfesseurDao(ProfesseurDao professeurDao) {
		this.professeurDao = professeurDao;
	}

	// get ALL List Of Professeur
	public List <Professeur>  listProfesseur () {
		return professeurDao.findAll();
	}
   
	// Save Professeur
	public Professeur saveProfesseur (Professeur professeur){
		return professeurDao.save(professeur);
	}
	
	// Delete Professeur
	public void deleteProfesseur (int id){
		professeurDao.delete(id);
	}
	
	public Professeur findProfesseurById (int id) {
		return professeurDao.findProfesseurById(id);
	}
	
	public Professeur updateProfesseur (Professeur professeur ) {
		
		Professeur prof = new Professeur();
		prof.setId(professeur.getId());
		prof.setMatiere(professeur.getMatiere());
		prof.setNom(professeur.getNom());	 
		return professeurDao.save(prof);		 
	}
	
}
