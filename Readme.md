# Getting Started

## Introduction
The purpose of this project is to produce the messages to a defined kafka topic. This project is created to help in simulation of the actual issue defined in the SimpleCamelKafkaConsumer application.

### Pre-Requisites
* [JDK 1.8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven 3.6](https://maven.apache.org/)
* [Apache Kafka 1.0.1](https://kafka.apache.org/downloads) or higher
 

### Setup
* Create a kafka topic with 15 partitions
* Configure below properties in application.properties

#### Mandatory

	kafka.topic
	kafka.camelKafkaOptions.brokers
	
#### Optional
	
	kafka.camelKafkaOptions.sslTruststorePassword
	kafka.camelKafkaOptions.sslTruststoreLocation
	kafka.camelKafkaOptions.sslKeystorePassword
	kafka.camelKafkaOptions.sslKeystoreLocation
	kafka.camelKafkaOptions.sslKeyPassword
	kafka.camelKafkaOptions.sslEndpointAlgorithm
	kafka.camelKafkaOptions.securityProtocol


### Order of Execution
Ensure that the below application is running before starting SimpleCamelKafkaProducer application.

	SimpleRestInterface

### Steps to Execute
Run the application using the below command

		mvn package

		mvn spring-boot:run
