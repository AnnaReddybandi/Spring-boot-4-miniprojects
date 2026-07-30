# 🏥 Hospital Appointment Booking System

A Spring Boot REST API project for managing hospital appointments. Patients can book appointments with doctors, update or cancel appointments, and search appointments using various custom query APIs.

---

# 📌 Project Overview

The Hospital Appointment Booking System is a Spring Boot application developed using a layered architecture.

It demonstrates:

- Spring Boot REST API
- Spring Data JPA
- MySQL Database
- CRUD Operations
- Custom Query Methods
- DTO (Request & Response)
- Bean Validation
- Global Exception Handling
- Custom Exceptions
- ResponseEntity
- Maven Project Structure

---

# 🚀 Technologies Used

- Java 17
- Spring Boot 3.5.x
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- Jakarta Validation
- Postman

---

# 📁 Project Structure

```
HospitalAppointmentBooking
│
├── src
│
├── main
│
│── java
│   └── com.example.hospitalappointmentbooking
│
│       ├── controller
│       │      AppointmentController.java
│       │
│       ├── dto
│       │      AppointmentRequest.java
│       │      AppointmentResponse.java
│       │
│       ├── exception
│       │      AppointmentNotFoundException.java
│       │      DuplicateAppointmentException.java
│       │      GlobalExceptionHandler.java
│       │
│       ├── model
│       │      Appointment.java
│       │
│       ├── repository
│       │      AppointmentRepository.java
│       │
│       ├── service
│       │      AppointmentService.java
│       │      AppointmentServiceImpl.java
│       │
│       ├── util
│       │      ApiResponse.java
│       │
│       └── HospitalAppointmentBookingApplication.java
│
└── resources
       application.properties
```

---

# ⚙️ Database Configuration

```
Database Name

hospital_appointment_db
```

application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_appointment_db?createDatabaseIfNotExist=true

spring.datasource.username=root

spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true
```

---

# 📦 Maven Dependencies

- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Spring Boot Starter Validation
- MySQL Connector
- Lombok
- Spring Boot DevTools
- Spring Boot Starter Test

---

# 📋 Entity

Appointment

| Field | Type |
|--------|------|
| appointmentId | Integer |
| patientName | String |
| doctorName | String |
| disease | String |
| appointmentDate | LocalDate |

---

# ✅ Validations

| Annotation | Description |
|------------|-------------|
| @NotBlank | Patient name required |
| @NotBlank | Doctor name required |
| @NotBlank | Disease required |
| @NotNull | Appointment date required |
| @FutureOrPresent | Date must be today or future |

---

# 🔥 CRUD APIs

## 1 Create Appointment

POST

```
http://localhost:8080/api/appointments
```

Request

```json
{
    "patientName":"Anna Reddy",
    "doctorName":"Dr Sharma",
    "disease":"Fever",
    "appointmentDate":"2026-08-10"
}
```

---

## 2 Get All Appointments

GET

```
http://localhost:8080/api/appointments
```

---

## 3 Get Appointment By Id

GET

```
http://localhost:8080/api/appointments/1
```

---

## 4 Update Appointment

PUT

```
http://localhost:8080/api/appointments/1
```

Request

```json
{
    "patientName":"Anna Reddy",
    "doctorName":"Dr Kumar",
    "disease":"Cold",
    "appointmentDate":"2026-08-12"
}
```

---

## 5 Delete Appointment

DELETE

```
http://localhost:8080/api/appointments/1
```

---

# 🔎 Custom Query APIs

## Search By Patient Name

GET

```
http://localhost:8080/api/appointments/patient/Anna
```

---

## Search By Doctor Name

GET

```
http://localhost:8080/api/appointments/doctor/Dr Sharma
```

---

## Search By Disease

GET

```
http://localhost:8080/api/appointments/disease/Fever
```

---

## Search By Date

GET

```
http://localhost:8080/api/appointments/date/2026-08-10
```

---

## Upcoming Appointments

GET

```
http://localhost:8080/api/appointments/upcoming
```

---

## Appointments Between Dates

GET

```
http://localhost:8080/api/appointments/between?startDate=2026-08-01&endDate=2026-08-31
```

---

## Total Appointments

GET

```
http://localhost:8080/api/appointments/count
```

---

# ⚠️ Custom Exceptions

## AppointmentNotFoundException

Thrown when appointment ID is not found.

Example

```
Appointment with ID 100 not found.
```

---

## DuplicateAppointmentException

Thrown when the same patient books the same doctor on the same date.

Example

```
Appointment already exists.
```

---

# 🌍 Global Exception Handler

Handles

- AppointmentNotFoundException
- DuplicateAppointmentException
- MethodArgumentNotValidException
- Exception

---

# 📄 Validation Error Example

Request

```json
{
    "patientName":"",
    "doctorName":"",
    "disease":"",
    "appointmentDate":null
}
```

Response

```json
{
    "patientName":"Patient name is required",
    "doctorName":"Doctor name is required",
    "disease":"Disease field cannot be empty",
    "appointmentDate":"Appointment date is required"
}
```

---

# 📄 Success Response Example

```json
{
    "appointmentId":1,
    "patientName":"Anna Reddy",
    "doctorName":"Dr Sharma",
    "disease":"Fever",
    "appointmentDate":"2026-08-10"
}
```

---

# 📄 Not Found Response

```json
{
    "status":404,
    "message":"Appointment with ID 10 not found."
}
```

---

# 📄 Duplicate Response

```json
{
    "status":400,
    "message":"Appointment already exists."
}
```

---

# ▶️ How to Run

## Step 1

Clone Project

```
git clone <repository-url>
```

---

## Step 2

Open in IntelliJ IDEA

---

## Step 3

Create MySQL Server

Username

```
root
```

Password

```
root
```

---

## Step 4

Run

```
HospitalAppointmentBookingApplication.java
```

---

## Step 5

Open Postman

Test all APIs.

---

# 📌 Features

- CRUD Operations
- DTO Pattern
- Layered Architecture
- Spring Data JPA
- MySQL Integration
- Automatic Database Creation
- Automatic Table Creation
- Bean Validation
- Custom Query Methods
- Exception Handling
- REST APIs
- ResponseEntity
- Maven Project
- Clean Code Structure

---

# 🎯 Future Enhancements

- JWT Authentication
- Spring Security
- Doctor Login
- Patient Login
- Admin Module
- Email Notifications
- SMS Notifications
- Appointment Status
- Pagination
- Sorting
- Swagger/OpenAPI Documentation
- Docker Support
- Unit Testing
- Integration Testing

---

# 👨‍💻 Author

**Anna Reddy**

Java Developer

---

# ⭐ If you found this project helpful, don't forget to star the repository.