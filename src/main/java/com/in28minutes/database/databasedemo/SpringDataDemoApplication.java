package com.in28minutes.database.databasedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.springdata.PersonSpringDataRepository;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PersonSpringDataRepository jpaRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User id 10001: {}", jpaRepository.findById(10001));
		logger.info("Inserting 10004: {}", jpaRepository.save(new Person("Tara", "Berlin", new Date())));
		logger.info("Update 10003: {}", jpaRepository.save(new Person(10003, "Pieter", "Utrecht", new Date())));
		jpaRepository.deleteById(10002);
		logger.info("All users: {}", jpaRepository.findAll());
	}

}

