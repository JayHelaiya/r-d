package com.jay.easyshop.commonservice.commondatabase.service;

import java.util.List;

import com.jay.easyshop.commonservice.utility.Model;


public interface GenericService<M extends Model> {
	  
	   M get(final Long id);
	   List<M> getAll();
	   void create(final M entity);
	   void update(final M entity);
	   void delete(final M entity);
	   void deleteById(final Long entityId);
	}