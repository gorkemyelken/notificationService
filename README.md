# Notification Service

Notification Service is a Spring Boot application designed to manage notification templates and criteria for sending notifications to patients based on defined conditions. It interacts with a MySQL database to store notification templates and target criteria.

## Technologies

- Java
- Spring Boot
- Maven
- MySQL (as the preferred RDBMS)

## Features

- Define notification templates with criteria (gender, age).
- Store target criteria and patients to send notifications.
- Evaluate newly created patients from Patient Service against defined criteria.
- Develop RESTful APIs to send notifications based on criteria.

## Getting Started

## Database Configuration

Install MySQL and configure the connection settings in src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/notificationdb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

## Running the Application

Run the Spring Boot application using Maven:

mvn spring-boot:run

Once the application starts successfully, you can test the APIs using http://localhost:8080.

## API Usage

- Create a Notification Template: POST /api/templates
- Update a Notification Template: PUT /api/templates/{templateId}
- Get Notification Template Details: GET /api/templates/{templateId}
- List All Notification Templates: GET /api/templates
- Send Notifications Based on Criteria: POST /api/sendNotification

## Sample Use Cases

- Define a new notification template with criteria (e.g., gender, age).
- Update an existing notification template.
- Retrieve details of a notification template.
- Send notifications to patients based on specified criteria.
