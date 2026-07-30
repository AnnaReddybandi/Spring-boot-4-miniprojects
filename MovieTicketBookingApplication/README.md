# 🎬 Movie Ticket Booking System

A complete **Spring Boot REST API** project that allows users to book, manage, and search movie tickets. This project demonstrates a real-world layered architecture using **Spring Boot, Spring Data JPA, MySQL, Bean Validation, DTOs, Custom Queries, Global Exception Handling, and REST APIs**.

---

# 📌 Project Overview

The Movie Ticket Booking System is a RESTful web application where users can:

- Book movie tickets
- View all booked tickets
- Search tickets using custom queries
- Update ticket details
- Cancel tickets
- Perform validations on user input
- Handle exceptions using global exception handling

This project follows industry-standard Spring Boot architecture.

---

# 🚀 Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- Maven
- Lombok
- Bean Validation
- REST APIs
- Postman

---

# 📂 Project Structure

```
MovieTicketBookingSystem
│
├── src
│   ├── main
│   │
│   ├── java
│   │   └── com.example.movieticketbookingsystem
│   │
│   │       ├── controller
│   │       │      TicketController.java
│   │       │
│   │       ├── service
│   │       │      TicketService.java
│   │       │      TicketServiceImpl.java
│   │       │
│   │       ├── repository
│   │       │      TicketRepository.java
│   │       │
│   │       ├── model
│   │       │      Ticket.java
│   │       │
│   │       ├── dto
│   │       │      TicketRequest.java
│   │       │      TicketResponse.java
│   │       │
│   │       ├── exception
│   │       │      TicketNotFoundException.java
│   │       │      DuplicateSeatException.java
│   │       │      GlobalExceptionHandler.java
│   │       │
│   │       ├── util
│   │       │      ApiResponse.java
│   │       │
│   │       └── MovieTicketBookingApplication.java
│   │
│   └── resources
│          application.properties
│
└── pom.xml
```

---

# ✨ Features

- Book Movie Ticket
- Get All Tickets
- Get Ticket By ID
- Update Ticket
- Cancel Ticket
- Search by Movie Name
- Search by Customer Name
- Search by Seat Number
- Search by Ticket Price
- Search by Price Range
- Sort Tickets by Price
- Sort Tickets by Movie Name
- Get Highest Price Ticket
- Get Lowest Price Ticket
- Get Total Ticket Count
- Input Validation
- Custom Exception Handling
- Global Exception Handling

---

# 🗄 Database Configuration

Create the database.

```sql
CREATE DATABASE movie_ticket_db;
```

Update **application.properties**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/movie_ticket_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

When the application starts, Hibernate will automatically create the required tables.

---

# ▶️ Running the Application

## Clone Repository

```bash
git clone https://github.com/your-username/MovieTicketBookingSystem.git
```

## Open Project

Import the project into IntelliJ IDEA as a **Maven Project**.

## Build Project

```bash
mvn clean install
```

## Run Project

```bash
mvn spring-boot:run
```

Application will start on

```
http://localhost:8080
```

---

# 📮 REST API Endpoints

## 1. Create Ticket

| Method | Endpoint |
|---------|----------|
| POST | `/api/tickets` |

Sample Request

```json
{
    "movieName":"Pushpa 2",
    "customerName":"Anna Reddy",
    "seatNumber":"A10",
    "ticketPrice":350
}
```

---

## 2. Get All Tickets

| Method | Endpoint |
|---------|----------|
| GET | `/api/tickets` |

---

## 3. Get Ticket By ID

| Method | Endpoint |
|---------|----------|
| GET | `/api/tickets/{id}` |

Example

```
GET /api/tickets/1
```

---

## 4. Update Ticket

| Method | Endpoint |
|---------|----------|
| PUT | `/api/tickets/{id}` |

---

## 5. Delete Ticket

| Method | Endpoint |
|---------|----------|
| DELETE | `/api/tickets/{id}` |

---

# 🔍 Custom Query APIs

## Search By Movie Name

```
GET /api/tickets/movie/{movieName}
```

Example

```
GET /api/tickets/movie/Pushpa 2
```

---

## Search By Customer Name

```
GET /api/tickets/customer/{customerName}
```

---

## Search By Seat Number

```
GET /api/tickets/seat/{seatNumber}
```

---

## Search By Price

```
GET /api/tickets/price/{price}
```

Returns all tickets with price greater than or equal to the specified value.

---

## Search By Price Range

```
GET /api/tickets/price-range/{min}/{max}
```

Example

```
GET /api/tickets/price-range/300/500
```

---

# 📊 Sorting APIs

## Sort Price Ascending

```
GET /api/tickets/sort/price/asc
```

---

## Sort Price Descending

```
GET /api/tickets/sort/price/desc
```

---

## Sort By Movie Name

```
GET /api/tickets/sort/movie
```

---

# 📈 Statistics APIs

## Highest Price Ticket

```
GET /api/tickets/highest-price
```

---

## Lowest Price Ticket

```
GET /api/tickets/lowest-price
```

---

## Total Tickets

```
GET /api/tickets/count
```

---

# ✅ Bean Validation

The application validates incoming request data using Jakarta Bean Validation.

| Field | Validation |
|-------|------------|
| Movie Name | `@NotBlank` |
| Customer Name | `@NotBlank` |
| Seat Number | `@NotBlank` |
| Ticket Price | `@Positive` |

Example Invalid Request

```json
{
    "movieName":"",
    "customerName":"",
    "seatNumber":"",
    "ticketPrice":-100
}
```

Example Response

```json
{
    "movieName":"Movie name is required",
    "customerName":"Customer name cannot be empty",
    "seatNumber":"Seat number is required",
    "ticketPrice":"Ticket price must be positive"
}
```

---

# ⚠ Exception Handling

## Custom Exceptions

- TicketNotFoundException
- DuplicateSeatException

## Global Exception Handler

Handles

- Validation Exceptions
- Resource Not Found
- Duplicate Seat Booking
- Internal Server Errors

Example

```json
{
    "status":404,
    "error":"Not Found",
    "message":"Ticket with ID 100 not found."
}
```

---

# 🏗 Project Architecture

```
                Client
                   │
                   ▼
          TicketController
                   │
                   ▼
           TicketService
                   │
                   ▼
        TicketServiceImpl
                   │
                   ▼
        TicketRepository
                   │
                   ▼
          MySQL Database
```

---

# 📬 Testing

All APIs can be tested using:

- Postman
- IntelliJ HTTP Client
- REST Client Extension

---

# 🔮 Future Enhancements

- JWT Authentication
- Spring Security
- Role-Based Access Control
- Online Payment Gateway
- Theatre Management
- Movie Management
- Seat Availability Dashboard
- Email Notifications
- SMS Notifications
- Pagination
- Sorting & Filtering
- Docker Support
- Unit Testing
- Integration Testing

---

# 👨‍💻 Author

**Anna Reddy**

Java Developer

GitHub

https://github.com/AnnaReddybandi

---

# ⭐ Support

If you found this project useful, consider giving it a ⭐ on GitHub.

Happy Coding! 🚀