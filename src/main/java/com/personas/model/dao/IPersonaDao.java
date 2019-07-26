package com.personas.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.personas.model.entity.Persona;

public interface IPersonaDao {
	
	public void save(Persona persona);
	public Persona getById(Long id);
	public List<Persona> findAll();
	public Persona update(Persona persona);
	public void delete(Long id);

}
