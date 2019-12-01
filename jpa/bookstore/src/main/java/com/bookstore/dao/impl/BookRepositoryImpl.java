/*package com.bookstore.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import com.bookstore.dao.BookRepositoryCustom;
import com.bookstore.model.Book;

@Repository
public class BookRepositoryImpl implements BookRepositoryCustom  {
	
	 EntityManager em;
	
	@Override
	public List<Book> findBooksByAuthorNameAndTitle(String authorName, String title) {

		    CriteriaBuilder cb = em.getCriteriaBuilder();
		    CriteriaQuery<Book> cq = cb.createQuery(Book.class);
		 
		    Root<Book> book = cq.from(Book.class);
		    List<Predicate> predicates = new ArrayList<>();
		     
		    if (authorName != null) {
		        predicates.add(cb.equal(book.get("author"), authorName));
		    }
		    if (title != null) {
		        predicates.add(cb.like(book.get("title"), "%" + title + "%"));
		    }
		    cq.where(predicates.toArray(new Predicate[0]));
		 
		    return em.createQuery(cq).getResultList();
	}
	
	static Specification<Book> hasAuthor(String author) {
	    return (book, cq, cb) -> cb.equal(book.get("author"), author);
	}
	
	static Specification<Book> titleContains(String title) {
	    return (book, cq, cb) -> cb.like(book.get("title"), "%" + title + "%");
	}

}
*/