
🚀 Enterprise Modernization POC – Cloud-Native Microservices

This project is a **cloud-native microservices proof of concept (POC)** that demonstrates how a traditional synchronous business flow can be modernized into **resilient, containerized, and independently deployable services** using Spring Boot and Docker.

The focus is on **real-world backend engineering practices**: service decomposition, resilience patterns, container orchestration, and production-ready design.

---

 🧩 Architecture Overview

```

Client
|
v
Order Service (8081)  --->  Payment Service (8082)
|
|--- Circuit Breaker (Resilience4j) + Fallback

```

---

 🛠️ Technology Stack

### Backend
- Java 17
- Spring Boot 3
- REST APIs
- Spring Web
- Spring Validation
- Spring Test (JUnit, MockMvc)

### Resilience & Reliability
- Resilience4j (Circuit Breaker, Fallback)
- Global exception handling

### Containerization & Orchestration
- Docker
- Docker Compose

### Build & Dev
- Maven
- Layered Docker images
- Environment-based configuration

---

## 📁 Project Structure

```

microservices/
│
├── docker-compose.yml
│
├── order-service/
│   ├── src/
│   ├── Dockerfile
│   ├── pom.xml
│   └── README.md
│
├── payment-service/
│   ├── src/
│   ├── Dockerfile
│   ├── pom.xml
│   └── README.md
│
└── docs/
└── architecture.md

```

---

## ⚙️ Services

### 🟦 Order Service
- Port: **8081**
- Validates orders
- Calls Payment Service
- Protected by circuit breaker
- Returns fallback when payment fails

**Endpoint**
```

POST /orders

```

---

### 🟩 Payment Service
- Port: **8082**
- Processes payment
- Simulates success/failure

**Endpoint**
```

POST /payments

````

---

## ▶️ How to Run the Project

### 1️⃣ Build images
```bash
docker compose build
````

### 2️⃣ Start services

```bash
docker compose up
```

### 3️⃣ Verify containers

```bash
docker ps
```

---

## 🧪 Testing with Postman

### Create Order

**POST**

```
http://localhost:8081/orders
```

**Request Body**

```json
{
  "productName": "Laptop",
  "amount": 45000
}
```

---

### Success Response

```
Order created & payment successful
```

---

### Fallback Response (Payment Service Down)

```
Order placed, but payment service is temporarily unavailable
```

---

## 🧯 Resilience Demonstration

1. Stop the `payment-service` container
2. Send order request again
3. Circuit breaker opens
4. Fallback method is executed
5. Order service remains available

This demonstrates **failure isolation and system resilience**.

---

## 🎯 Why This POC Matters

This project demonstrates:

* Microservice decomposition
* Synchronous service communication
* Circuit breaker pattern
* Container-first development
* Independent service deployment
* Cloud-native readiness

It reflects **how modern backend systems are built in real production environments**.

---

## 🚧 Roadmap (Next Phases)

* Kafka for async communication
* API Gateway
* OpenTelemetry tracing
* Centralized config service
* Kubernetes deployment
* CI/CD with GitHub Actions
* Observability dashboards

---

 👨‍💻 Author

Malob Chaudhuri
Senior Backend Engineer (Java)


