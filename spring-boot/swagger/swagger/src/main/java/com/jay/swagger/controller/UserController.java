package com.jay.swagger.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.jay.swagger.dao.UserDao;
import com.jay.swagger.dao.model.User;
import com.jay.swagger.exceptions.UserNotFoundException;


@RestController
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return userDao.findAll();
	}
	
	
	@GetMapping("/users/{id}")
	public @ResponseBody ResponseEntity<User> getUser(@PathVariable int id,UriComponentsBuilder ucBuilder) {
		 
		User user = userDao.findOne(id);
		if(user==null) {
			 throw new UserNotFoundException("id-"+id);
		 }
		 return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@RequestBody User user,UriComponentsBuilder ucBuilder) {
		
		user = userDao.save(user);
		
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getUser(user.getUserId(),null));
		user.add(linkTo.withRel("user"));
		 
		HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(user.getUserId()).toUri());
		
	        
	     return new ResponseEntity<>(user,headers, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable int id) {
		User user = userDao.deleteById(id);
		if(user==null) {
			 throw new UserNotFoundException("id-"+id);
		 }
					
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
