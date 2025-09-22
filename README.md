# Healthcare Microservices Platform

A microservices architecture demonstration showcasing modern distributed systems design, inter-service communication patterns, and cloud deployment.

## Architecture

**Services:**
- **API Gateway** (4004) - Spring Cloud Gateway for routing
- **Auth Service** (4001) - JWT authentication
- **Patient Service** (4000) - Patient CRUD operations  
- **Billing Service** (9001) - gRPC billing management
- **Analytics Service** (4002) - Event processing via Kafka

**Communication:**
- REST APIs for external clients
- gRPC for internal service communication
- Kafka for asynchronous messaging

## Tech Stack

- **Backend**: Java 21, Spring Boot 3.5.5, Spring Security, JPA
- **Communication**: gRPC, Protocol Buffers, REST APIs
- **Messaging**: Kafka, Event-driven architecture
- **Infrastructure**: Docker, AWS Fargate, AWS CDK, PostgreSQL, LocalStack
- **Testing**: JUnit 5, RestAssured, Integration tests
