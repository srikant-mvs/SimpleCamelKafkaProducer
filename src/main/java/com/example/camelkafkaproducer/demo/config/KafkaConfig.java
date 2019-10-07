package com.example.camelkafkaproducer.demo.config;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


/**
 * Class to pick the properties defined for Kafka from application.properties and create a camel endpoint to call kafka
 * 
 * @author Srikant
 *
 */
@Configuration("kafkaConfig")
@ConfigurationProperties("kafka")
public class KafkaConfig {

	private String topic;
	
	private int numberOfMessages;
	
	private final Map<String, String> camelKafkaOptions = new HashMap<>();
	
	private String kafkaURL = "";
	
	/**
	 * Forms the kafka url based on the configuration
	 */
	@PostConstruct
	public void constructKafkaURL() {
		StringBuilder urlBuilder = new StringBuilder("kafka:" + getTopic());
        if (!getCamelKafkaOptions().isEmpty()) {
        	urlBuilder.append("?");
            getCamelKafkaOptions().forEach((key, value) -> {
                if (StringUtils.isNotBlank(value)) {
                	urlBuilder.append(key).append("=").append(value).append("&");
                }
            });
        }

		this.kafkaURL = StringUtils.stripEnd(StringUtils.stripEnd(urlBuilder.toString(), "&"),"?");
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Map<String, String> getCamelKafkaOptions() {
		return camelKafkaOptions;
	}

	public String getKafkaURL() {
		return kafkaURL;
	}

	public int getNumberOfMessages() {
		return numberOfMessages;
	}

	public void setNumberOfMessages(int numberOfMessages) {
		this.numberOfMessages = numberOfMessages;
	}
	
	
}
