package com.classe.controller;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.classe.model.Professeur;
import com.classe.service.ProfesseurService;


@Controller
@Component
@Path("profs")
//@Produces(MediaType.APPLICATION_JSON)
public class ProfesseurController {

	
	@Autowired
	private ProfesseurService ProfesseurService;
	
	 public ProfesseurService getProfesseurService() {
		return ProfesseurService;
	}

	public void setProfesseurService(ProfesseurService professeurService) {
		ProfesseurService = professeurService;
	}
	
	// get List Professeur
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public List<Professeur> listProfesseur() {
	 	return ProfesseurService.listProfesseur();
	
	}
	
	// GET Professeur by id
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Professeur findProfesseurById(@PathParam("id") int id) {
		return ProfesseurService.findProfesseurById(id);		
	}

		
	
	//Save professeur
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Professeur saveProfesseur (Professeur professeur){ 
		   return ProfesseurService.saveProfesseur(professeur);
	}
	
	// delete professeur WITH Response 
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteProfesseur (@PathParam("id") int id) {
      ProfesseurService.deleteProfesseur(id);

  }

	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Professeur update(@PathParam("id") int id , Professeur professeur) {
		
		professeur.setId(id);		
		return ProfesseurService.updateProfesseur(professeur);
		
	} 
	
}
