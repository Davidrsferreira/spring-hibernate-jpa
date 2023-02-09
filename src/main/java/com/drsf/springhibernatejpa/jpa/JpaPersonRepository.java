package com.drsf.springhibernatejpa.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.drsf.springhibernatejpa.entity.Person;

@Repository
@Transactional
public class JpaPersonRepository {

	@PersistenceContext
	EntityManager entityManager;

	public Person findById(int id) {
		return this.entityManager.find(Person.class, id);
	}

	public Person save(Person person) {
		return entityManager.merge(person);
	}

	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	}

	public List<Person> findAll() {
		TypedQuery<Person> query = entityManager.createNamedQuery("find_all", Person.class);
		return query.getResultList();
	}

}
