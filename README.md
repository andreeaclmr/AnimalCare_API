# 🐾 AnimalCare API

AnimalCare API is a Spring Boot application designed to manage a wildlife reserve by handling animal records, authentication, and secure data access.

## 🚀 Features
- **Authentication**: 
- [in progress] Admin-only access with JWT or Basic Auth.
- **Animal Management**:
    -[x] List all animals with pagination (max 20 per page).
    -[x] List animals by family (max 10 per page).
    -[x] List animals by country (no pagination).
    -[x] List animals by family and type.
    -[x] CRUD operations (admin only).
- **Image Uploads**: 
     -[x] Each animal can have an associated image.
---
## 🛠️ **Tech Stack**
- **Backend**: Java 21, Spring Boot (Web, JPA, Security, Validation)
- **Database**: H2 (Development), PostgreSQL/MySQL (Production)
- **Authentication**: JWT or Basic Auth
- **API Documentation**: OpenAPI (Swagger)
- **Build Tool**: Maven

---
## 📂 **Project Structure**
AnimalCare_API 

│── src

    ├── main/java/com/example/AnimalCare_API 
    ├── animal (Controllers, Services, DTOs) 
    ├── family (Family Entity & Repository) 
    ├── service (ImageService, WebConfig) 
    ├── type (Enums for categorization) 
    ├── AnimalCareApiApplication.java 

├── resources

    ├──static/images 
    ├── application.properties (Environment configurations) 
    ├── data.sql (Initial database setup)
    ├── test/java/com/example/AnimalCare_API (Unit tests) 

    │── target (Build artifacts) 
    │── uploads/images (Stored animal images)


---

## 📌 **Database Schema (ER Diagram)**
![Kanban Screenshot](https://github.com/andreeaclmr/AnimalCare_API/blob/46962018f0ceb0099bca0c4b947d1550652f91ec/ER.png)

## 🖥️ **System Architecture (UML Diagram)**
![Kanban Screenshot](https://github.com/andreeaclmr/AnimalCare_API/blob/main/UML.png)

## 🔧 Setup & Running Locally

### 1️⃣ Clone the repository

```
git clone https://github.com/your-repo/AnimalCare_API.git
cd AnimalCare_API
```
### 2️⃣ Set up environment variables
Modify application.properties to configure the database:
```spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

### 3️⃣ Run the application
```mvn spring-boot:run```

### 4️⃣ Access the API
Swagger UI: http://localhost:8080/swagger-ui.html

## 📜 API Endpoints

### 🔓 Public Endpoints
| Method | Endpoint                               | Description                                  |
|--------|-----------------------------------------|----------------------------------------------|
| GET    | /api/animals                           | Get all animals (paginated)                    |
| GET    | /api/animals/family?familyId=1          | Get animals by family                         |
| GET    | /api/animals/country?country=Brazil     | Get animals by country                        |
| GET    | /api/animals/type?familyId=1&type=Mammal | Get animals by family & type                  |

### 🔒 Admin Endpoints (Requires Authentication)
| Method | Endpoint                               | Description                                  |
|--------|-----------------------------------------|----------------------------------------------|
| POST    | /api/animals                           | Add a new animal                              |
| PUT     | /api/animals/{id}                       | Update an animal                               |
| DELETE  | /api/animals/{id}                       | Delete an animal                               |


## 🧪 Testing

Run unit tests:

```mvn test```


## Kanban with Asana for Project Management
![Kanban Screenshot](https://github.com/andreeaclmr/AnimalCare_API/blob/main/KanbanAsana.png)

## GIT Branches
#### -  main
#### -  animal
#### -  family


## About Me
### **Andreea Celmare**

[<img src="https://img.shields.io/badge/github-%23121011.svg?&style=for-the-badge&logo=github&logoColor=white" alt="GitHub" />](https://github.com/andreeaclmr) </br>
[<img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn" />](https://www.linkedin.com/in/andreea-alina-celmare/)
