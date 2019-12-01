package com.foobar.foo.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.foobar.bar.domain.Bar;
import com.foobar.foo.domain.Foo;

/**
 * @author jayesh.helaiya
 *
 */
@Repository
public class FooRepositoryImpl implements FooRepository {

	@PersistenceContext(unitName="barEntityManagerFactory")
	EntityManager barEntityManager;
	
	@PersistenceContext()
	EntityManager fooEntityManager;


	@Override
	public List<Foo> getfoos() {
		CriteriaBuilder criteriaBuilder = fooEntityManager.getCriteriaBuilder();
		CriteriaQuery<Foo> criteriaQuery = criteriaBuilder.createQuery(Foo.class);
		Root<Foo> root = criteriaQuery.from(Foo.class);
		criteriaQuery.select(root);
		TypedQuery<Foo> query = fooEntityManager.createQuery(criteriaQuery);
		List<Foo> foos = query.getResultList();
		System.out.println(foos);
		return foos;

	}
	
	@Override
	public List<Bar> getbars() {
		CriteriaBuilder criteriaBuilder = barEntityManager.getCriteriaBuilder();
		CriteriaQuery<Bar> criteriaQuery = criteriaBuilder.createQuery(Bar.class);
		Root<Bar> root = criteriaQuery.from(Bar.class);
		criteriaQuery.select(root);
		TypedQuery<Bar> query = barEntityManager.createQuery(criteriaQuery);
		List<Bar> bars = query.getResultList();
		System.out.println(bars);
		return bars;
	}
}
