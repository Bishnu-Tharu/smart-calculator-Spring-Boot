# Smart Calculator — Spring Boot

A RESTful calculator application built with **Spring Boot** that provides basic and advanced mathematical operations, calculation history, input validation, exception handling, and MySQL database integration.

The application also includes a responsive browser-based calculator interface built with **HTML, CSS, and JavaScript**.

---

## 1. Features

* Basic arithmetic operations

  * Addition
  * Subtraction
  * Multiplication
  * Division
* Advanced mathematical operations

  * Square
  * Power
  * Modulus
  * Square Root
  * Maximum Value
  * Minimum Value
  * Absolute Value
  * Factorial
* Calculation history
* Delete calculation history
* Input validation
* Exception handling
* MySQL database integration
* BigDecimal-based calculations for improved precision
* Responsive web-based calculator interface
* Maven Wrapper support

---

## 2. Technology Stack

| Technology              | Purpose                         |
| ----------------------- | ------------------------------- |
| Java 21                 | Programming language            |
| Spring Boot 4.1.1       | Application framework           |
| Spring Web MVC          | REST API development            |
| Spring Data JPA         | Database persistence            |
| Jakarta Bean Validation | Input validation                |
| MySQL                   | Relational database             |
| Lombok                  | Boilerplate code reduction      |
| Maven                   | Build and dependency management |
| HTML                    | Web page structure              |
| CSS                     | User interface styling          |
| JavaScript              | Frontend functionality          |

---

## 3. Application Architecture

The application follows a layered architecture to separate responsibilities and maintain a clean project structure.

```text
                         Client
                           │
                           ▼
                 ┌───────────────────┐
                 │    Controller     │
                 │ CalculatorController
                 └─────────┬─────────┘
                           │
                           ▼
                 ┌───────────────────┐
                 │      Service      │
                 │  CalculatorService│
                 └─────────┬─────────┘
                           │
                           ▼
                 ┌───────────────────┐
                 │    Repository     │
                 │CalculationRepository
                 └─────────┬─────────┘
                           │
                           ▼
                 ┌───────────────────┐
                 │      MySQL        │
                 │     Database      │
                 └───────────────────┘
```

### Layer Responsibilities

**Controller Layer**

Handles HTTP requests and exposes the calculator REST endpoints.

**Service Layer**

Contains the mathematical operations, business rules, validation logic, and calculation-history processing.

**Repository Layer**

Uses Spring Data JPA to communicate with the MySQL database.

**Entity Layer**

Maps Java objects to database tables.

**DTO Layer**

Defines the request and response objects used by the REST API.

**Exception Handling**

Handles invalid input and mathematical errors and returns appropriate error responses.

---

## 4. Project Structure

```text
smart-calculator-Spring-Boot/
│
├── .mvn/
│   └── wrapper/
│       └── maven-wrapper.properties
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── calculation/
│   │   │           ├── CalculationInitializrApplication.java
│   │   │           │
│   │   │           ├── controller/
│   │   │           │   └── CalculatorController.java
│   │   │           │
│   │   │           ├── dto/
│   │   │           │   ├── CalculatorRequest.java
│   │   │           │   └── CalculatorResponse.java
│   │   │           │
│   │   │           ├── entity/
│   │   │           │   └── CalculatorEntity.java
│   │   │           │
│   │   │           ├── GlobalException/
│   │   │           │
│   │   │           ├── respository/
│   │   │           │   └── CalculationRepository.java
│   │   │           │
│   │   │           └── service/
│   │   │               ├── CalculatorService.java
│   │   │               └── CalculatorServiceImp.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   │           └── index.html
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── calculation/
│
├── .gitattributes
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

> **Note:** The package is currently named `respository` in the project structure. For a future cleanup, consider renaming it to the conventional `repository`.

---

## 5. Requirements

Before running the application, install the following:

* **JDK 21 or later**
* **MySQL Server**
* **Git**
* **Maven** *(optional — Maven Wrapper is included)*

Verify Java:

```bash
java -version
```

Verify Maven:

```bash
mvn -version
```

---

## 6. Database Configuration

Create the MySQL database:

```sql
CREATE DATABASE calculationInitializr;
```

Configure the database connection in:

```text
src/main/resources/application.properties
```

Example configuration:

```properties
spring.application.name=Calculation-Initializr

spring.datasource.url=jdbc:mysql://localhost:3306/calculationInitializr
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

The application uses:

```properties
spring.jpa.hibernate.ddl-auto=update
```

to automatically create or update the required database table.

> **Security:** Do not commit real database passwords or other sensitive credentials to GitHub. Use environment variables or a secure secrets-management solution for production deployments.

---

## 7. Getting Started

### Clone the Repository

```bash
git clone https://github.com/Bishnu-Tharu/smart-calculator-Spring-Boot.git
cd smart-calculator-Spring-Boot
```

### Run the Application

#### Windows

```cmd
mvnw.cmd spring-boot:run
```

#### Linux / macOS

```bash
./mvnw spring-boot:run
```

If Maven is installed globally:

```bash
mvn spring-boot:run
```

The application will start on:

```text
http://localhost:8080
```

---

## 8. Web Interface

The project includes a browser-based calculator interface located at:

```text
src/main/resources/static/index.html
```

After starting the application, open:

```text
http://localhost:8080
```

The web interface provides access to the supported mathematical operations and calculation history.

---

## 9. REST API

### Base URL

```text
http://localhost:8080/calculator
```

### Available Endpoints

|  Method  | Endpoint      | Description                  |
| :------: | ------------- | ---------------------------- |
|  `POST`  | `/add`        | Add two numbers              |
|  `POST`  | `/subtract`   | Subtract two numbers         |
|  `POST`  | `/multiply`   | Multiply two numbers         |
|  `POST`  | `/division`   | Divide two numbers           |
|  `POST`  | `/square`     | Calculate the square         |
|  `POST`  | `/power`      | Calculate a power            |
|  `POST`  | `/modulus`    | Calculate the remainder      |
|  `POST`  | `/squareRoot` | Calculate the square root    |
|  `POST`  | `/max`        | Find the maximum value       |
|  `POST`  | `/min`        | Find the minimum value       |
|  `POST`  | `/absolute`   | Calculate the absolute value |
|  `POST`  | `/factorial`  | Calculate the factorial      |
|   `GET`  | `/history`    | Retrieve calculation history |
| `DELETE` | `/history`    | Delete calculation history   |

### Request Format

Most calculation endpoints accept the following JSON request:

```json
{
  "num1": 10,
  "num2": 5
}
```

`num2` is required only for operations that use two values.

### Response Example

```json
{
  "num1": 10,
  "num2": 5,
  "operation": "ADD",
  "result": 15
}
```

---

## 10. Validation and Error Handling

The application validates mathematical operations and rejects invalid input.

Examples include:

* Division by zero
* Modulus by zero
* Negative square-root values
* Negative factorial values
* Decimal factorial values
* Factorial values greater than `32`
* Negative or decimal power values
* Missing required values
* Invalid numeric input

This ensures that invalid mathematical operations are handled consistently instead of producing unexpected results.

---

## 11. Calculation History

Every successful calculation can be stored in the MySQL database.

The calculation history contains:

| Field       | Description                           |
| ----------- | ------------------------------------- |
| `id`        | Auto-generated calculation identifier |
| `num1`      | First input number                    |
| `num2`      | Second input number                   |
| `operation` | Mathematical operation                |
| `result`    | Calculated result                     |

Retrieve history:

```http
GET /calculator/history
```

Delete all history:

```http
DELETE /calculator/history
```

---

## 12. Testing

Run the test suite using the Maven Wrapper.

### Windows

```cmd
mvnw.cmd test
```

### Linux / macOS

```bash
./mvnw test
```

Using Maven:

```bash
mvn test
```

---

## 13. Build

Create the application JAR:

### Windows

```cmd
mvnw.cmd clean package
```

### Linux / macOS

```bash
./mvnw clean package
```

The generated JAR will be available inside:

```text
target/
```

Run the packaged application:

```bash
java -jar target/Calculation-Initializr-0.0.1-SNAPSHOT.jar
```

---

## 14. Maven Commands

| Command                    | Description                          |
| -------------------------- | ------------------------------------ |
| `mvnw.cmd spring-boot:run` | Start the application on Windows     |
| `./mvnw spring-boot:run`   | Start the application on Linux/macOS |
| `./mvnw clean`             | Remove generated build files         |
| `./mvnw compile`           | Compile the project                  |
| `./mvnw test`              | Run tests                            |
| `./mvnw package`           | Create the application JAR           |
| `./mvnw clean package`     | Clean and build the application      |

---

## 15. Future Improvements

Planned or possible improvements include:

* OpenAPI / Swagger API documentation
* Expanded unit and integration testing
* Pagination for calculation history
* Calculation timestamps
* User-specific calculation history
* Authentication and authorization
* Docker support
* Environment-based configuration
* Flyway or Liquibase database migrations
* GitHub Actions CI/CD
* Automated API testing

---

## 16. Author

**Bishnu Chaudhary**

Smart Calculator — Spring Boot

Built with:

**Java · Spring Boot · REST API · Spring Data JPA · MySQL · HTML · CSS · JavaScript**

---

## 17. License

No license has currently been specified for this project.
