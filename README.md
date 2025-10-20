# Employee API

A simple Spring Boot RESTful web service for managing employee data. Supports querying and adding employees via HTTP GET and POST requests.

## Features
- Query all employees (`GET /employees`)
- Add a new employee (`POST /employees`)
- In-memory employee list (no database required)
- Unit tests for controller endpoints and edge cases

## Technologies
- Java 17+
- Spring Boot 3.5.6
- Maven
- JUnit 5

## Setup
1. **Clone the repository:**
   ```bash
   git clone https://github.com/vashirij/employee-api.git
   cd employee-api
   ```
2. **Build the project:**
   ```bash
   ./mvnw clean package
   ```
3. **Run the application:**
   ```bash
   java -jar target/employee-api-0.0.1-SNAPSHOT.jar
   ```

## API Endpoints
### Get all employees
- **Request:**
  ```http
  GET /employees
  ```
- **Response:**
  - 200 OK
  - JSON array of employees

### Add a new employee
- **Request:**
  ```http
  POST /employees
  Content-Type: application/json
  {
    "first_name": "Anna",
    "last_name": "Smith",
    "employee_id": "EMP005",
    "email": "anna.smith@example.com",
    "title": "Designer"
  }
  ```
- **Response:**
  - 200 OK
  - JSON of the added employee

## Testing
Run all unit tests:
```bash
./mvnw test
```
Tests cover:
- GET and POST endpoints
- Edge cases (missing fields, duplicate IDs, invalid email)

## Project Structure
- `src/main/java/com/grinefalcon/employee_api/Employee.java`
- `src/main/java/com/grinefalcon/employee_api/Employees.java`
- `src/main/java/com/grinefalcon/employee_api/EmployeeManager.java`
- `src/main/java/com/grinefalcon/employee_api/EmployeeController.java`
- `src/main/java/com/grinefalcon/employee_api/RestServiceApplication.java`
- `src/test/java/com/grinefalcon/employee_api/EmployeeControllerTest.java`

## License
MIT
