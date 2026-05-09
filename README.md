# URL Shortener

A backend application built using Spring Boot that generates short URLs for long links and redirects users efficiently.

---

## Features

- Generate short URLs
- Redirect to original URLs
- RESTful APIs
- MySQL database integration
- Docker support
- Clean backend architecture

---

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Docker for MySQL Container

---

## API Endpoints

### Create Short URL

```http
POST /api/url/shorten
```

#### Request Body

```json
{
  "originalUrl": "https://example.com/very/long/url"
}
```

#### Response

```json
{
  "shortUrl": "http://localhost:8080/abc123"
}
```

---

### Redirect To Original URL

```http
GET /{shortCode}
```

Redirects the user to the original URL.

---

## Database Configuration

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:port/yourdatabase
spring.datasource.username=yourusername
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## Run Locally

### Clone Repository

```bash
git clone https://github.com/Mini2002/Url_Shortner.git
```

### Navigate To Project

```bash
cd Url_Shortner
```

### Build Project

```bash
mvn clean install
```

### Run Application

```bash
mvn spring-boot:run
```

Application runs at:

```bash
http://localhost:8080
```
---
## Learning Outcomes

This project helped in understanding:

- REST API development
- Spring Boot backend architecture
- Database integration
- Docker basics
- Git and GitHub workflow

---