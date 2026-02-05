
### Enterprise Modernization POC – Phase 2

**Event-Driven Microservices using Kafka**

---

## 📌 Overview

This project demonstrates **enterprise modernization** by evolving a **synchronous microservices architecture** into an **event-driven system** using **Apache Kafka**.

**Phase 2 focuses on:**

* Decoupling services
* Asynchronous communication
* Improved scalability and fault tolerance

---

## 🏗 Architecture (Phase 2)

### Before (Phase 1 – Synchronous)

```
Order Service  --->  Payment Service
        (REST call, tight coupling)
```

### After (Phase 2 – Event-Driven)

```
Order Service  --->  Kafka Topic  --->  Payment Service
        (publishes event)        (consumes event)
```

---

## 🔁 Event Flow

1. Client creates an order via **Order Service**
2. Order Service:

   * Validates request
   * Publishes `OrderCreatedEvent` to Kafka
3. Payment Service:

   * Listens to Kafka topic
   * Processes payment asynchronously
4. Order Service responds immediately (non-blocking)

---

## 📦 Modules

### 1️⃣ order-service

* Produces Kafka events
* Publishes `OrderCreatedEvent`
* Validates business rules
* Fully stateless and container-ready

### 2️⃣ payment-service

* Consumes Kafka events
* Processes payment logic
* Demonstrates consumer group handling

### 3️⃣ common-events

* Shared event contracts
* Prevents class-mismatch and serialization issues
* Used as a dependency by both services

---

## 🧾 Key Classes Introduced (Phase 2)

### Order Service

* `OrderService`
* `OrderController`
* `KafkaProducerConfig`
* `OrderCreatedEvent` (from common-events)

### Payment Service

* `PaymentEventListener`
* `PaymentRequest`
* Kafka consumer configuration

### Common

* `OrderCreatedEvent`

---

## ⚙️ Technology Stack

* Java 17
* Spring Boot
* Spring Kafka
* Apache Kafka
* Docker & Docker Compose
* Maven
* REST APIs

---

## 🐳 Running the Application

```bash
docker-compose up --build
```

### Services

* Order Service → `http://localhost:8081`
* Payment Service → Kafka consumer
* Kafka → Dockerized broker

---

## 📬 Sample Request

```http
POST /orders
{
  "productName": "Laptop",
  "amount": 50000
}
```

### Response

```
Order accepted and sent for payment processing
```

Payment processing happens **asynchronously** via Kafka.

---

## 🎯 Enterprise Benefits Demonstrated

* Loose coupling between services
* Non-blocking architecture
* Improved scalability
* Fault tolerance
* Cloud-native, container-first design
* Event-driven architecture (EDA)

---

## 🚀 Phase 2 Outcome

✔ Successfully migrated from synchronous REST calls to Kafka-based event processing
✔ Implemented shared event contracts
✔ Verified producer and consumer via Docker logs
✔ Production-ready enterprise pattern

---

## 🔜 Next Steps (Phase 3 Ideas)

* Retry & Dead Letter Topics (DLQ)
* Schema Registry
* Exactly-once semantics
* Observability (metrics + tracing)

---

## 📌 Author

**Malob Chaudhuri**
Senior Java / Spring Boot Developer
Enterprise Modernization | Microservices | Kafka






