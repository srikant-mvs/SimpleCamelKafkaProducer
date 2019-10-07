package com.example.camelkafkaproducer.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleCamelKafkaProducerApplication implements CommandLineRunner {
	
	@Autowired
	private MessageProducer messageProducer;

	public static void main(String[] args) {
		SpringApplication.run(SimpleCamelKafkaProducerApplication.class, args);
	}
	
    @Override
    public void run(String... args) throws Exception {	
    	messageProducer.process();
    }

}
