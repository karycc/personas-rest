package com.personas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personas.model.entity.Persona;
import com.personas.model.service.IPersonaService;

@RestController
@RequestMapping("/api")
public class PersonaController {
	
	@Autowired
	private IPersonaService personaService;
	
	@GetMapping("/get/{id}")
	public Persona getPersona(@PathVariable Long id){
		
		return personaService.getById(id);
		
	}
	
	@GetMapping("/personas")
	public List getPersonas(){
		
		return personaService.findAll();
		
	} 
	@PostMapping("/persona")
	public void savePersona(@RequestBody Persona persona){
		personaService.save(persona);
		
	}
	
	 @PutMapping("/persona/{id}")
	 public void updatePersona(@RequestBody Persona newPersona, @PathVariable Long id) {
		 
		 Persona persona = personaService.getById(id);
		 System.out.println("Id encontrado: "+ persona.getId());
		 if(persona!=null) {
			 newPersona.setId(id);
			 personaService.update(newPersona);
		 }
		 
	 }
	
	@DeleteMapping("/persona/{id}")
	  public void deletePersona(@PathVariable Long id) {
		personaService.delete(id);
	  }
	

}
