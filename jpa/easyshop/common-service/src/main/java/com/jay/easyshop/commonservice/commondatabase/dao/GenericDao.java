package com.jay.easyshop.commonservice.commondatabase.dao;

import java.util.List;

import com.jay.easyshop.commonservice.utility.Model;

public interface GenericDao<M extends Model> {
	  
	   M get(final Long id);
	   List<M> getAll();
	   void create(final M entity);
	   void update(final M entity);
	   void delete(final M entity);
	   void deleteById(final Long entityId);
	}