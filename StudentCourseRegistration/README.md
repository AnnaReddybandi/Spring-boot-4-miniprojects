# 🎓 Student Course Registration System

![Java](https://img.shields.io/badge/Java-25-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.5.3-brightgreen)
![Maven](https://img.shields.io/badge/Maven-3.9-blue)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![JPA](https://img.shields.io/badge/SpringData-JPA-success)
![Hibernate](https://img.shields.io/badge/Hibernate-ORM-yellow)
![REST API](https://img.shields.io/badge/REST-API-red)

A complete **Spring Boot REST API based Student Course Registration System**.

This project demonstrates real-time backend development using:

- Spring Boot
- Spring Data JPA
- Hibernate ORM
- MySQL Database
- DTO Pattern
- Bean Validation
- Exception Handling
- Derived Query Methods
- JPQL Queries
- REST APIs
- PATCH Mapping
- Sorting
- Searching
- Filtering
- Aggregate Functions
- Layered Architecture


---

# 📌 Project Overview

The **Student Course Registration System** is a backend application used to manage student information and course registrations.

The application provides complete student management functionality through REST APIs.

Main features:

- Register Student
- View All Students
- View Student By ID
- Update Student Details
- Delete Student
- Partial Update Student
- Search Students
- Filter Students
- Sort Students
- Find Top Students
- Student Statistics
- Validation Handling
- Global Exception Handling


---

# 🚀 Technologies Used

| Technology | Version |
|------------|---------|
| Java | 25 |
| Spring Boot | 3.5.3 |
| Spring Data JPA | 3.5.1 |
| Hibernate | 6.6.18 |
| MySQL | 8.0 |
| Maven | 3.9 |
| Lombok | 1.18.38 |
| IntelliJ IDEA | 2026 |
| Postman | Latest |


---

# 📂 Project Structure


```
StudentCourseRegistration
│
├── src/main/java/com/example/studentcourseregistration
│
├── controller
│       └── StudentController.java
│
├── dto
│       ├── StudentRequest.java
│       └── StudentResponse.java
│
├── entity
│       └── Student.java
│
├── repository
│       └── StudentRepository.java
│
├── service
│       ├── StudentService.java
│       └── impl
│             └── StudentServiceImpl.java
│
├── exception
│       ├── ResourceNotFoundException.java
│       └── GlobalExceptionHandler.java
│
├── StudentCourseRegistrationApplication.java
│
└── resources
        └── application.properties
```


---

# 🏗 Application Architecture


```
                 Client

                   |

              REST API Request

                   |

              Controller Layer

                   |

              Service Layer

                   |

             Repository Layer

                   |

              MySQL Database

```


---

# 🛢 Database Configuration


`application.properties`


```properties
spring.application.name=StudentCourseRegistration

server.port=8080


spring.datasource.url=jdbc:mysql://localhost:3306/student_course_db?createDatabaseIfNotExist=true

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


The project uses:


### Spring Web

Used for creating REST APIs.


### Spring Data JPA

Used for database operations.


### Hibernate ORM

Used as JPA implementation.


### MySQL Connector

Used for MySQL database connectivity.


### Validation

Used for request validation.


### Lombok

Used for reducing boilerplate code.


### DevTools

Used for automatic restart during development.


---

# 👨‍🎓 Entity Details


## Student Entity


| Field | Type | Description |
|------|------|-------------|
| studentId | Integer | Primary Key |
| studentName | String | Student Name |
| email | String | Unique Email |
| courseName | String | Registered Course |
| age | Integer | Student Age |


---

# ✅ Validation Rules


| Field | Validation |
|------|------------|
| studentName | @NotBlank |
| email | @NotBlank + @Email |
| courseName | @NotBlank |
| age | @Min(18) |


---

# 🔥 REST API Documentation


Base URL:


```
http://localhost:8080/api/students
```


---

# 📌 CRUD Operations


## 1. Register Student


### POST

```
/api/students
```


Request:

```json
{
    "studentName":"Anna Reddy",
    "email":"anna@gmail.com",
    "courseName":"Java",
    "age":25
}
```


Response:


```json
{
    "studentId":1,
    "studentName":"Anna Reddy",
    "email":"anna@gmail.com",
    "courseName":"Java",
    "age":25
}
```


---

## 2. Get All Students


### GET


```
/api/students
```


---

## 3. Get Student By ID


### GET


```
/api/students/{id}
```


Example:


```
/api/students/1
```


---

## 4. Update Student


### PUT


```
/api/students/{id}
```


---

## 5. Delete Student


### DELETE


```
/api/students/{id}
```


---

## 6. Partial Update


### PATCH


```
/api/students/{id}
```


Example:


```json
{
    "courseName":"Spring Boot"
}
```


---

# 🔍 Student Name Search APIs


| Method | API | Description |
|--------|-----|-------------|
| GET | `/name/{studentName}` | Exact Match |
| GET | `/name/contains/{studentName}` | Contains |
| GET | `/name/start/{studentName}` | Starts With |
| GET | `/name/end/{studentName}` | Ends With |


Example:


```
GET /api/students/name/Anna
```


---

# 📚 Course Search APIs


| API | Description |
|-----|-------------|
| `/course/{courseName}` | Exact Course |
| `/course/contains/{courseName}` | Contains |
| `/course/start/{courseName}` | Starts With |
| `/course/end/{courseName}` | Ends With |


Example:


```
GET /api/students/course/Java
```


---

# 📧 Email Search APIs


| API | Description |
|-----|-------------|
| `/email/contains/{email}` | Contains Email |
| `/email/start/{email}` | Starts With |
| `/email/end/{email}` | Ends With |


---

# 🎂 Age Filter APIs


| API | Description |
|-----|-------------|
| `/age/{age}` | Find By Age |
| `/age/greater/{age}` | Greater Than |
| `/age/less/{age}` | Less Than |
| `/age/between?min=20&max=30` | Between Ages |


---

# 🔎 Multiple Condition Search


## Name and Course


```
GET

/api/students/name-course?studentName=Anna&courseName=Java
```


## Course and Age


```
GET

/api/students/course-age?courseName=Java&age=25
```


## Dynamic Search


```
GET

/api/students/search?studentName=Anna&courseName=Java
```


---

# 📈 Sorting APIs


| API | Description |
|-----|-------------|
| `/sort/name/asc` | Name Ascending |
| `/sort/name/desc` | Name Descending |
| `/sort/course/asc` | Course Sorting |
| `/sort/age/asc` | Age Ascending |
| `/sort/age/desc` | Age Descending |


---

# ⭐ Top Records APIs


| API | Description |
|-----|-------------|
| `/top5-oldest` | Top 5 Oldest Students |
| `/top10-youngest` | Top 10 Youngest Students |
| `/latest` | Latest Student |


---

# 📊 Statistics APIs


| API | Description |
|-----|-------------|
| `/count` | Total Students |
| `/average-age` | Average Age |
| `/max-age` | Maximum Age |
| `/min-age` | Minimum Age |


---

# ❌ Exception Handling


Implemented:


- ResourceNotFoundException
- Validation Exception
- Global Exception Handler


Example Error:


```json
{
    "status":404,
    "message":"Student not found with id : 10"
}
```


---

# 🗄 Repository Features


Spring Data JPA Derived Queries:


✔ Exact Match

✔ Contains

✔ Starts With

✔ Ends With

✔ Greater Than

✔ Less Than

✔ Between

✔ Multiple Conditions

✔ Sorting

✔ Top Records


---

# 📊 JPQL Queries


Implemented:


- Average Student Age
- Maximum Student Age
- Minimum Student Age


---

# ▶️ How To Run Project


## Step 1: Clone Repository


```bash
git clone https://github.com/AnnaReddybandi/StudentCourseRegistration.git
```


---

## Step 2: Open Project


Open using:


```
IntelliJ IDEA
```


---

## Step 3: Configure MySQL


Update:


```
application.properties
```


with your MySQL username and password.


---

## Step 4: Build


```bash
mvn clean install
```


---

## Step 5: Run Application


```bash
mvn spring-boot:run
```


or run:


```
StudentCourseRegistrationApplication.java
```


---

# 🧪 API Testing


Recommended tools:


- Postman
- IntelliJ HTTP Client
- cURL


---

# ✨ Features Implemented


✅ REST API Development

✅ CRUD Operations

✅ PATCH Mapping

✅ DTO Pattern

✅ Bean Validation

✅ Custom Exceptions

✅ Global Exception Handling

✅ Spring Data JPA

✅ Hibernate ORM

✅ MySQL Integration

✅ Derived Query Methods

✅ JPQL Queries

✅ Searching

✅ Filtering

✅ Sorting

✅ Statistics APIs

✅ Clean Architecture


---

# 🚀 Future Enhancements


- Spring Security
- JWT Authentication
- Role Based Authorization
- Swagger Documentation
- Pagination
- Docker Deployment
- Unit Testing
- Email Notification
- Student Login Module
- Course Payment Module
- Redis Cache


---

# 👨‍💻 Author


## Anna Reddy


Java Developer


GitHub:

https://github.com/AnnaReddybandi


---

# 📜 License


This project is developed for educational and learning purposes.


---

# ⭐ Support


If you like this project, give this repository a ⭐ on GitHub.


---

# 🙏 Thank You


Happy Coding ❤️