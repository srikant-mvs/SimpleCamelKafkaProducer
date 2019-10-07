package com.example.camelkafkaproducer.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.camelkafkaproducer.demo.config.KafkaConfig;


public class KafkaRoute extends RouteBuilder {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private KafkaConfig kafkaConfig;

	/**
	 * Route created to produce messages to kafka topic
	 */
	@Override
	public void configure() throws Exception {
		logger.debug("configure():start");
		if (kafkaConfig.getTopic() != null && kafkaConfig.getCamelKafkaOptions() != null && !kafkaConfig.getCamelKafkaOptions().isEmpty()) {
	        from("direct:start").to("bean:messageProducer");
		}
	}
}
