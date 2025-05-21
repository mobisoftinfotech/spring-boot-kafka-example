# Spring Boot Kafka Example

This project demonstrates the integration of Spring Boot with Apache Kafka, implementing a distributed messaging system with a multi-broker Kafka cluster.

## Project Overview

This is a Spring Boot application that showcases Kafka integration with the following features:
- Spring Boot 3.5.0-SNAPSHOT
- Java 21
- Apache Kafka with a 3-broker cluster
- Spring Kafka for message handling

## Prerequisites

- Java 21 or higher
- Maven
- Docker and Docker Compose

## Project Structure

```
├── src/                    # Source code directory
├── docker-compose.yml      # Kafka cluster configuration
├── pom.xml                 # Project dependencies and build configuration
└── README.MD              # Project documentation
```

## Kafka Cluster Setup

The project uses a 3-broker Kafka cluster with the following configuration:
- Broker 1: Ports 9092, 9093, 29092
- Broker 2: Ports 9094, 9095, 29093
- Broker 3: Ports 9096, 9097, 29094

### Key Kafka Configuration
- Replication Factor: 3
- Number of Partitions: 3
- Transaction State Log Min ISR: 2
- Inter-broker Communication: Internal listener

## Docker Compose Setup

The project includes a `docker-compose.yml` file that sets up a 3-broker Kafka cluster. Here's how to manage the cluster:

### Starting the Cluster
```bash
# Start all services in detached mode
docker-compose up -d

# View logs of all services
docker-compose logs -f

# View logs of a specific broker
docker-compose logs -f broker1
```

### Stopping the Cluster
```bash
# Stop all services
docker-compose down

# Stop and remove volumes
docker-compose down -v
```

### Checking Cluster Status
```bash
# List running containers
docker-compose ps

# Check broker status
docker-compose exec broker1 kafka-topics.sh --bootstrap-server localhost:9092 --list
```

### Cluster Configuration Details
The Docker Compose file configures three Kafka brokers with:
- Separate ports for each broker
- Internal and external listeners
- Controller quorum voting
- Replication factor of 3
- Minimum ISR of 2
- 3 partitions per topic

## Getting Started

1. Start the Kafka cluster:
   ```bash
   docker-compose up -d
   ```

2. Build the project:
   ```bash
   ./mvnw clean install
   ```

3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

## Dependencies

The project uses the following main dependencies:
- `spring-boot-starter-web`: For REST API support
- `spring-kafka`: For Kafka integration
- `spring-boot-starter-test`: For testing support
- `spring-kafka-test`: For Kafka testing utilities

## License

This project is licensed under the MIT License - see the LICENSE file for details.
