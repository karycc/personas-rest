package com.personas.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.personas.model.entity.Persona;

@Repository
public class PersonaDaoImpl implements IPersonaDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void save(Persona persona) {
		em.persist(persona);
		
	}

	@Override
	public Persona getById(Long id) {
		Persona persona = em.find(Persona.class, id);
		return persona;
	}

	@Override
	public List<Persona> findAll() {
		
		return em.createQuery("from Persona").getResultList();
	}

	@Override
	@Transactional
	public Persona update(Persona persona) {
		
		return em.merge(persona);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Persona persona = getById(id);
		em.remove(persona);
		
	}

}
