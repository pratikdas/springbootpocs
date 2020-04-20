package com.pratik.todolistwithtests;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodolistwithtestsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistwithtestsApplication.class, args);
	}

	
	@PostConstruct
	public void postProcess() {
		System.out.println("Starting todo app");
	}
}
