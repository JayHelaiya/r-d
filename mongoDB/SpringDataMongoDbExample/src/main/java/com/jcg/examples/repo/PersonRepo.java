package com.jcg.examples.repo;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jcg.examples.entity.User;

public interface PersonRepo extends CrudRepository<User, Long>
{
		@Query("{'name' : ?0}")
		public Iterable<User> searchByName(String personName);

}
