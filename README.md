# XharkTank

![Made with love in India](https://madewithlove.now.sh/in?heart=true&colorB=%23f41027)
## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.divyansh.xharktank.XharktankApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```



## Features

- Get all the pitches `GET 'http://<Server_URL>/pitches'`
- Get a specific pitch with pitch id. `GET 'http://<Server_URL>/pitches/2'`
- Create a pitch `POST 'http://<Server_URL>/pitches'`
- Create a offer for a pitch `POST 'http://<Server_URL>/pitches/1/makeOffer'`


## Tech

Xharktank uses below tech stack:

- `Spring Boot`
- `Spring Web`
- `Spring Data JPA`
- `Lombok`
- `MySQL`

## Installation

Xharktank requires [Java](https://nodejs.org/) v8+ to run.

Install the dependencies using maven and start the server.

```sh
cd divyansh-bhowmick3-ME_BUILDOUT_XHARKTANK
mvn clean install
mvn spring-boot:run
```

Developed by:  `Divyansh Bhowmick😎`
