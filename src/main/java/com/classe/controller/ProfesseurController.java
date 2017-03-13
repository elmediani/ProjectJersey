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
@Path("professeur")
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


	// Display Hello World
	@GET
	 @Path("/HelloWorld")
	 @Produces({"application/json"})
     public String getHelloWorld(){
		
		return "Hello World from Jersey";
	}
	
	// get List Professeur
	@GET
	@Path("/listProfesseur")
	@Produces({"application/json"})
    public List<Professeur> listProfesseur() {
	 	return ProfesseurService.listProfesseur();
	
	}
	
	// GET Professeur by id
	@GET
	@Path("/{id}")
	@Produces({"application/json"})
	public Professeur findProfesseurById(@PathParam("id") int id) {
		return ProfesseurService.findProfesseurById(id);		
	}
	
	
	// Save professeur WITH response
	@POST
	@Path("/saveProfesseur")
	@Consumes({"application/json"})
	public Response saveProfesseur (){ 
	
		Professeur professeur= new Professeur("Ouissal","Math");
	    Professeur prof = ProfesseurService.saveProfesseur(professeur);		

	    return Response.created(URI.create("http://localhost:8090/api/professeur/"+prof.getId()))
					.build();
	}
		
	// delete professeur WITH Response 
	@DELETE
	@Path("{id}")
	public Response deleteProfesseur(@PathParam("id") int id) {
		ProfesseurService.deleteProfesseur(id);
	    return Response.accepted().build();
	}
	
	// Update professeur by Id 
//	@PUT
//	@Path("/{id}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response updateProfesseur(@PathParam("id") int id) {
//		
//		
//		Professeur professeur= new Professeur("Fatima-Zahra","Business");
//
//		Professeur prof =  ProfesseurService.findProfesseurById(id);
//		prof.setMatiere(professeur.getMatiere());
//		prof.setNom(professeur.getNom());
//		
//		ProfesseurService.saveProfesseur(prof);
//								
//		return Response.ok()
//				.build();
//		//Response.created(URI.create("http://localhost:8090/api/professeur/"+prof.getId())).build();
//
//	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, Professeur p) {
		
		Professeur prof =  ProfesseurService.findProfesseurById(id);
		p.setId(id);
		prof.setNom(p.getNom());
		prof.setMatiere(p.getMatiere());
		
		ProfesseurService.saveProfesseur(p);
		
		return Response.ok()
				.build();
		
	} 
}
