package com.example.camelkafkaproducer.demo;

import java.util.UUID;

import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.camelkafkaproducer.demo.config.KafkaConfig;

/**
 * Class to send messages to a kafka topic
 * 
 * @author Srikant
 *
 */
@Service("messageProducer")
public class MessageProducer {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private KafkaConfig kafkaConfig;
	
	@Autowired
    private ProducerTemplate producerTemplate;

	public void process() {
        int numberOfMessages = kafkaConfig.getNumberOfMessages() > 0 ? kafkaConfig.getNumberOfMessages() : 1;

        for (int i=0; i < numberOfMessages; i++) {
        	UUID generateRandomText = UUID.randomUUID();
            logger.debug("Message {} -> {}", i, generateRandomText);
			producerTemplate.sendBody(kafkaConfig.getKafkaURL(), generateRandomText.toString());
        }
	}

}
