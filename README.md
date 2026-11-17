# Tourist Management REST API

## Technologies
- Java 17
- Spring Boot 3.4.5
- Spring Web
- Spring Data JPA
- MySQL
- Swagger UI / OpenAPI

## Package
`com.soa.klef`

## 1. Create the database
Open MySQL Workbench and run `database/touristdb.sql`.

## 2. Configure MySQL
Open `src/main/resources/application.properties` and replace:

`spring.datasource.password=YOUR_MYSQL_PASSWORD`

with your local MySQL password. Update the username too if it is not `root`.

## 3. Run the project
From the project root, run:

```bash
mvn spring-boot:run
```

Or import the folder into Spring Tool Suite / IntelliJ / Eclipse as an existing Maven project and run `TouristApplication.java`.

## 4. Swagger UI
Open:

`http://localhost:8080/swagger-ui/index.html`

The `token` header is displayed for both endpoints in Swagger.

## 5. Existing token for this lab example
`my-secret-token-123`

No token generation is implemented.

## 6. API endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/tourists` | Fetch all tourists |
| GET | `/api/tourists/{id}` | Fetch one tourist by ID |

For both endpoints, enter this header in Swagger:

- Name: `token`
- Value: `my-secret-token-123`

## 7. Expected test results

- Valid token and existing tourist: `200 OK`
- Missing token: `500 Internal Server Error`, body `Invalid or Missing Token`
- Invalid token: `500 Internal Server Error`, body `Invalid or Missing Token`
- Valid token and nonexistent tourist ID: `404 Not Found`

Note: HTTP 401 Unauthorized is normally preferable for missing or invalid authentication credentials. HTTP 500 is implemented here only to match the stated lab requirement.
