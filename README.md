## Example of containerizing Gradle based Multi Module Spring Boot application using Docker

This simple crud application is designed to demonstrate configuration and launch in a Docker container.

### Stack: Spring Boot, Spring Data, Spring WebFlux, PostgreSQL, Lombok, Gradle, Docker

### Project structure:

```
docker-example  
├── api (subproject)  
│   ├── src    
│   ├── build.gradle  
│   └── Dockerfile   
├── data (subproject)  
│   ├── src    
│   ├── build.gradle  
│   └── Dockerfile   
├── build.gradle  
├── docker-compose.yml  
└── settings.gradle
```

### Application launch:

**1. Clone the repository**

```bash
git clone https://github.com/smaginv/docker-example.git && cd docker-example
```

**2. Build project using Gradle**

```bash
./gradlew build 
```

**3. Run the app using docker compose**

```bash
docker compose up -d
```

**The app will start running at:**  
http://localhost:8080/

---

### REST API

| Method | Path             | Description         |
|--------|------------------|---------------------|
| GET    | /api/people/{id} | Get person by id    |
| GET    | /api/people      | Get all people      |
| PUT    | /api/people/{id} | Update person       |
| POST   | /api/people      | Create person       |
| DELETE | /api/people/{id} | Delete person by id |

GET (Get person by id) Curl:  
`curl -X 'GET' 'http://localhost:8080/api/people/1'`

GET (Get all people) Curl:  
`curl -X 'GET' 'http://localhost:8080/api/people'`

PUT (Update person) Curl:  
`curl -X 'PUT' 'http://localhost:8080/api/people/1' -H 'Content-Type: application/json' -d '{"firstName": "Updated", "email": "updated@email.ru"}'`

POST (Create person) Curl:  
`curl -X 'POST' 'http://localhost:8080/api/people' -H 'Content-Type: application/json' -d '{"firstName": "Created", "email": "created@email.ru"}'`

DELETE (Delete person by id) Curl:  
`curl -X 'DELETE' 'http://localhost:8080/api/people/1'`