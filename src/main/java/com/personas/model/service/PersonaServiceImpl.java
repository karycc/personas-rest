package com.personas.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personas.model.dao.IPersonaDao;
import com.personas.model.entity.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaDao personaDao;
	
	@Override
	public void save(Persona persona) {
		personaDao.save(persona);
	}

	@Override
	public Persona getById(Long id) {
		return personaDao.getById(id);
	}

	@Override
	public List<Persona> findAll() {
		
		return personaDao.findAll();
	}

	@Override
	public Persona update(Persona persona) {
		
		return personaDao.update(persona);
	}

	@Override
	public void delete(Long id) {
		personaDao.delete(id);
	}

}
