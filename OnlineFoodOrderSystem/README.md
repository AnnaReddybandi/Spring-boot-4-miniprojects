# 🍔 Online Food Order System

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen)
![Maven](https://img.shields.io/badge/Maven-3.9-blue)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![JPA](https://img.shields.io/badge/SpringData-JPA-success)
![REST API](https://img.shields.io/badge/REST-API-red)

A complete **Spring Boot REST API** project for managing online food orders.

This project demonstrates real-world Spring Boot development using **Spring Data JPA, MySQL, Validation, DTO Pattern, Exception Handling, Custom Queries, JPQL, REST APIs, PATCH Mapping, and Layered Architecture.**

---

# 📌 Project Overview

The Online Food Order System allows customers to place food orders through REST APIs.

The application supports:

- Create Food Order
- View All Orders
- View Order by ID
- Update Order
- Delete Order
- Partial Update (PATCH)
- Customer Search
- Food Search
- Quantity Filter
- Price Filter
- Sorting
- Aggregate Statistics
- Duplicate Order Validation
- Global Exception Handling

---

# 🚀 Technologies Used

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Hibernate ORM
- MySQL Database
- Maven
- Lombok
- Bean Validation
- REST APIs
- Postman
- IntelliJ IDEA

---

# 📂 Project Structure

```
OnlineFoodOrderSystem
│
├── controller
│      FoodOrderController.java
│
├── dto
│      OrderRequest.java
│      OrderResponse.java
│
├── exception
│      DuplicateOrderException.java
│      OrderNotFoundException.java
│      GlobalExceptionHandler.java
│
├── model
│      FoodOrder.java
│
├── payload
│      ApiResponse.java
│
├── repository
│      FoodOrderRepository.java
│
├── service
│      FoodOrderService.java
│      FoodOrderServiceImpl.java
│
├── OnlineFoodOrderSystemApplication.java
│
└── resources
       application.properties
```

---

# 🛢 Database Configuration

```properties
spring.application.name=OnlineFoodOrderSystem

server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/online_food_order_db?createDatabaseIfNotExist=true

spring.datasource.username=root

spring.datasource.password=root

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

spring.jpa.properties.hibernate.format_sql=true

spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

---

# 📦 Maven Dependencies

- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Spring Boot Starter Validation
- MySQL Connector
- Lombok
- Spring Boot DevTools

---

# 📋 Entity

| Field | Type |
|---------|------|
| orderId | Integer |
| customerName | String |
| foodItem | String |
| quantity | Integer |
| price | Double |

---

# ✅ Validation

| Field | Validation |
|---------|------------|
| customerName | @NotBlank |
| foodItem | @NotBlank |
| quantity | @Min(1) |
| price | @NotNull |

---

# 📌 CRUD APIs

| Method | URL | Description |
|----------|-------------------------|----------------|
| POST | /orders | Create Order |
| GET | /orders | Get All Orders |
| GET | /orders/{id} | Get Order By ID |
| PUT | /orders/{id} | Update Order |
| PATCH | /orders/{id} | Partial Update |
| DELETE | /orders/{id} | Delete Order |

---

# 👤 Customer APIs

| API |
|------|
| GET /orders/customer |
| GET /orders/customer/contains |
| GET /orders/customer/starts |
| GET /orders/customer/ends |

---

# 🍕 Food APIs

| API |
|------|
| GET /orders/food |
| GET /orders/food/contains |
| GET /orders/food/starts |
| GET /orders/food/ends |

---

# 📊 Quantity APIs

| API |
|------|
| GET /orders/quantity |
| GET /orders/quantity/greater |
| GET /orders/quantity/less |
| GET /orders/quantity/between |

---

# 💰 Price APIs

| API |
|------|
| GET /orders/price |
| GET /orders/price/greater |
| GET /orders/price/less |
| GET /orders/price/between |

---

# 🔍 Search APIs

| API |
|------|
| GET /orders/customer-food |
| GET /orders/customer-price |
| GET /orders/food-quantity |
| GET /orders/search |

---

# 📈 Sorting APIs

| API |
|------|
| GET /orders/sort/price/asc |
| GET /orders/sort/price/desc |
| GET /orders/sort/customer |
| GET /orders/sort/food |

---

# ⭐ Top APIs

| API |
|------|
| GET /orders/top5 |
| GET /orders/top10 |
| GET /orders/latest |

---

# 📊 Statistics APIs

| API |
|------|
| GET /orders/statistics/total-orders |
| GET /orders/statistics/revenue |
| GET /orders/statistics/average-price |
| GET /orders/statistics/max-price |
| GET /orders/statistics/min-price |

---

# 📬 Sample POST Request

**POST**

```
http://localhost:8080/orders
```

Request Body

```json
{
  "customerName":"Anna Reddy",
  "foodItem":"Chicken Biryani",
  "quantity":2,
  "price":350
}
```

---

# ✅ Sample Response

```json
{
  "orderId":1,
  "customerName":"Anna Reddy",
  "foodItem":"Chicken Biryani",
  "quantity":2,
  "price":350
}
```

---

# PATCH Example

```
PATCH /orders/1
```

```json
{
   "price":450
}
```

---

# Validation Error Example

```json
{
  "customerName":"",
  "foodItem":"",
  "quantity":0,
  "price":null
}
```

Response

```json
{
  "status":400,
  "error":"Validation Failed",
  "messages":{
      "customerName":"Customer name is required",
      "foodItem":"Food item cannot be empty",
      "quantity":"Quantity must be at least 1",
      "price":"Price is mandatory"
  }
}
```

---

# ❌ Exception Handling

The project includes custom exception handling.

- OrderNotFoundException
- DuplicateOrderException
- ValidationException
- GlobalExceptionHandler

---

# 🗄 Repository Features

Spring Data JPA Derived Queries

- Exact Match
- Ignore Case
- Contains
- Starts With
- Ends With
- Greater Than
- Less Than
- Between
- Multiple Conditions
- Sorting
- Top Records

JPQL Queries

- Total Orders
- Total Revenue
- Average Price
- Maximum Price
- Minimum Price

---

# 🏗 Architecture

```
Client
   │
REST API
   │
Controller
   │
Service
   │
Repository
   │
MySQL Database
```

---

# ▶️ How to Run

### Clone Repository

```bash
git clone https://github.com/AnnaReddybandi/OnlineFoodOrderingSystem.git
```

### Navigate

```bash
cd OnlineFoodOrderingSystem
```

### Configure MySQL

Update

```
application.properties
```

with your database username and password.

### Run Project

```bash
mvn spring-boot:run
```

or

Run

```
OnlineFoodOrderSystemApplication.java
```

---

# 🧪 Testing

Use

- Postman
- IntelliJ HTTP Client
- cURL

to test all REST APIs.

---

# ✨ Features

- REST APIs
- CRUD Operations
- PATCH API
- Bean Validation
- DTO Pattern
- Layered Architecture
- Custom Exceptions
- Global Exception Handling
- Spring Data JPA
- Derived Queries
- JPQL Queries
- Sorting
- Filtering
- Searching
- Aggregate Functions
- MySQL Integration
- Clean Code
- Professional Folder Structure

---

# 🚀 Future Enhancements

- Spring Security
- JWT Authentication
- Role Based Authorization
- Swagger/OpenAPI
- Docker
- Unit Testing
- Pagination
- Email Notifications
- Payment Gateway
- Order Status Tracking
- Redis Cache

---

# 👨‍💻 Author

**Anna Reddy**

Java Developer

GitHub:

https://github.com/AnnaReddybandi

---

# 📜 License

This project is developed for educational and learning purposes.

---

# ⭐ If you like this project

Give this repository a ⭐ on GitHub.

---

# 🙏 Thank You

Happy Coding ❤️