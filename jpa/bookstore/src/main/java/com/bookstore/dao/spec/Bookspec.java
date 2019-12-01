package com.bookstore.dao.spec;

import com.bookstore.dao.Specification;
import com.bookstore.model.Book;

public class Bookspec{
	
	public Bookspec() {}
	
	
	/*public static Specification<Book> hasAuthor(String author) {
	      return new Specification<Book>() {
	     
			@Override
			public Predicate toPredicate(Root<Book> book, CriteriaQuery cq, CriteriaBuilder cb) {
			    return (book, cq, cb) -> cb.equal(book.get("author"), author);
			}
	      };
	  }*/



	public static Specification<Book> hasAuthor(String author) {
	    return (book, cq, cb) -> cb.equal(book.get("author"), author);
	}
	 
	public static Specification<Book> titleContains(String title) {
	    return (book, cq, cb) -> cb.like(book.get("title"), "%" + title + "%");
	}
}
