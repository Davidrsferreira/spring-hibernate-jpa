package com.drsf.springhibernatejpa;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.drsf.springhibernatejpa.entity.Person;
import com.drsf.springhibernatejpa.jpa.JpaPersonRepository;

@SpringBootApplication
public class SpringHibernateJpaApplication implements CommandLineRunner {

	@Autowired
	private JpaPersonRepository repository;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("insert new person -> {}", repository.save(new Person("David Ferreira", "LpCity", new Date())));
		log.info("insert new person -> {}", repository.save(new Person("Paula Santos", "PGCity", new Date())));
		log.info("All users -> {}", repository.findAll());
		log.info("find by id -> {}", repository.findById(1));
		log.info("update -> {}", repository.save(new Person(1, "DRSF", "Porto", new Date())));
		log.info("find by id -> {}", repository.findById(1));
		repository.deleteById(1);
		log.info("delete by id -> {1}");
		log.info("find by id -> {}", repository.findById(1));
	}

}
