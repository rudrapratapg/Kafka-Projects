#Kafka-Projects

An educational repository showcasing the integration of Apache Kafka with Java. This project includes two distinct components:

#Producer: 
Demonstrates the functionality of Kafka producers by publishing messages to Kafka topics.

#Consumer:
Explores the mechanics of Kafka consumers by reading and processing messages from Kafka topics.

This repository aims to provide a hands-on learning experience with Apache Kafka's core APIs. Ideal for developers and learners exploring event-driven architectures.

---

# Kafka Projects

## Overview

This repository contains Kafka-based implementations, showcasing Producer and Consumer functionalities, along with custom serializers and deserializers. These projects demonstrate various Kafka concepts such as handling orders and tracking truck locations.

## Features

### 1. **Consumer**
   - **Implemented Classes**:
     - `OrderConsumer`: Consumes Kafka messages related to orders using custom deserializers.
     - `TruckTrackingConsumer`: Consumes Kafka messages related to truck tracking using custom deserializers.
   - **Custom Deserializers**:
     - `OrderDeserializer`: Deserializes order data in JSON format.
     - `TruckTrackingDeserializer`: Deserializes truck tracking data with coordinates.

### 2. **Producer**
   - **Implemented Classes**:
     - `OrderProducer`: Produces Kafka messages for orders using custom serializers.
     - `TruckTrackingProducer`: Produces Kafka messages for tracking truck locations.
   - **Custom Serializers**:
     - `OrderSerializer`: Serializes order objects into JSON format.
     - `TruckTrackingSerializer`: Serializes truck tracking objects containing longitude and latitude details.

## Getting Started

### Prerequisites
- Apache Kafka installed and running on your local environment.
- Java Development Kit (JDK) 8 or higher.
- Maven for dependency management.

### Running the Project
1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-repo/Kafka-Projects.git
   cd Kafka-Projects
   ```
2. **Build the project**:
   ```bash
   mvn clean install
   ```
3. **Run the Consumer and Producer**:
   - Navigate to the respective module (`Consumer` or `Producer`) and execute the main classes:
     ```bash
     java -cp target/your-jar-file.jar com.deepak.kafka.orderproducer.App
     ```

## Folder Structure

### Consumer
- Contains modules to consume data from Kafka topics.
- Key Files:
  - `OrderConsumer.java`: Processes and displays orders.
  - `TruckTrackingConsumer.java`: Processes and displays truck tracking information.

### Producer
- Contains modules to produce data to Kafka topics.
- Key Files:
  - `OrderProducer.java`: Sends order data to Kafka.
  - `TruckTrackingProducer.java`: Sends truck tracking data to Kafka.

## Dependencies

- `org.apache.kafka:kafka-clients:3.9.0`
- `com.fasterxml.jackson.core:jackson-databind:2.18.3`
- `junit:junit:3.8.1`

## Acknowledgments

This repository is developed and maintained by **Deepak**. It serves as an excellent starting point to learn and implement Kafka-based projects.
