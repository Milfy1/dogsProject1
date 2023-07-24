# Dogs Project

## Overview

This is a Java-based application that uses Maven, Docker, and Kafka. The application appears to be related to managing information about dogs, their owners, and tracking devices.

## Project Structure

- `src/main/java`: Contains the Java source files for the application.
- `src/main/resources`: Contains resources needed for the application.
- `src/test/java`: Contains the test source files for the application.
- `pom.xml`: The Project Object Model (POM) file for Maven.
- `Dockerfile`: Used by Docker to create a container for the application.
- `docker-compose.yml`: Used to define and run multi-container Docker applications.

## Setup and Installation

###Using docker build.

1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Build the project using Maven: `mvn clean install`.
4. Build the Docker image: `docker build -t dog-project .`.
5. Run the Docker container: `docker run -p 8080:8080 dog-project`.

###Using docker-compose

1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Run the Docker containers using the docker-compose.yml file: `docker-compose up -d`.

## Usage

Once the application is running, you can interact with it through its exposed endpoints. Detailed usage instructions are not available at this time.
