# Architecture Overview

## High-Level Design (HLD)
- Client → API Gateway → Microservices
- Async communication via Kafka
- Centralized logging & monitoring
- Externalized configuration
- Stateless services

## Low-Level Design (LLD)
### Order Service
- REST endpoints for order lifecycle
- Validations & exception handling
- Persistence layer abstraction

### Payment Service
- Event-driven payment processing
- Retry & circuit breaker logic

### Notification Service
- Async notification handling
- Fail-safe design

---

## Non-Functional Requirements
- Scalability
- Resilience
- Observability
- Security
- Testability

---

## Deployment Strategy (Conceptual)
- Docker images per service
- Kubernetes orchestration
- Environment-based config
- Blue-green deployments
