package com.example.easynotes.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class NoteRepositoryCustomImpl implements NoteRepositoryCustom{

	@PersistenceContext
    EntityManager entityManager;
	
	@Override
	public String getTitleById(Long id) {
		   Query query = entityManager.createNativeQuery("SELECT title FROM notes where id=1 ");
		   return (String) query.getSingleResult();
	        
	}
}
