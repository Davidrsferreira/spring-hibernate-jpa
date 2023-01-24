package com.drsf.springhibernatejpa;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.drsf.springhibernatejpa.entity.Person;
import com.drsf.springhibernatejpa.jdbc.PersonJDBC;

@SpringBootApplication
public class SpringHibernateJpaApplication implements CommandLineRunner {

	@Autowired
	private PersonJDBC jdbc;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("All users -> {}", jdbc.findAll());
		log.info("find by id -> {}", jdbc.findById(10001));
		log.info("delete by id -> {}", jdbc.deleteById(10001));
		log.info("insert new person -> {}", jdbc.insert(new Person(10006, "Test new person", "location", new Date())));
		log.info("update -> {}", jdbc.insert(new Person(10001, "DRSF", "Porto", new Date())));
	}

}
