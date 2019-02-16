package com.in28minutes.database.databasedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PersonJpaRepository jpaRepository;
	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User id 10001: {}", jpaRepository.findById(10001));
		logger.info("Inserting 10004: {}", jpaRepository.insert(new Person("Tara", "Berlin", new Date())));
		logger.info("Update 10003: {}", jpaRepository.update(new Person(10003, "Pieter", "Utrecht", new Date())));
		/*logger.info("All users: {}", jpaRepository.findAll());
		logger.info("Deleting 10002, no of rows deleted: {}", jpaRepository.deleteById(10002));
		*/
	}

}

