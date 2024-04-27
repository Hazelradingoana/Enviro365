# Enviro365


Enviro365 Waste Sorting Application RESTPOINT.

Overview:
The Enviro365 Waste Sorting Application is a Spring Boot application aimed at promoting sustainable waste management practices. 
It includes REST endpoints for data retrieval and manipulation related to waste categories, disposal guidelines, and recycling tips. 
The application utilizes an in-memory H2 database for data storage.


Technical Considerations:

Package Structure: All code is organized within the package com.enviro.assessment.grad001.HazelRadingoana.
Primary Key: Each record in the database has a primary key called "id" to uniquely identify it.
Interface Design: The interfaces are modeled and implemented following best practices from an Object-Oriented perspective.
Database Implementation: An in-memory H2 database is used to store application data.
Spring Boot Application: The submission is a Spring Boot application with REST endpoints for communication between frontend and backend systems.


Installation:

Clone the repository: git clone <repository-url>
Configure the application properties as needed.
Build the project: mvn clean install
Run the application: java -jar target/waste-sorting-app-1.0-SNAPSHOT.jar

Endpoints:

/api/waste-categories: CRUD operations for waste categories.
/api/disposal-guidelines: CRUD operations for disposal guidelines.
/api/recycling-tips: CRUD operations for recycling tips.

Usage:

Access the REST endpoints using a client application or tools like cURL or Postman.
Send requests to retrieve, create, update, or delete data related to waste categories, disposal guidelines, and recycling tips.

Dependencies:

Java 8+
Maven
Spring Boot
H2 Database