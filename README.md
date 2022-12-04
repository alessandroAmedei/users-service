### JAX-RS Quarkus App by Alessandro Amedei

### Run docker postgres:latest container
    docker run -p 5433:5432 --name users-postgres -d -e POSTGRES_PASSWORD=postgres postgres

### Run docker app container
    docker run -p 7001:7001 --name users-service -d -e QUARKUS_DATASOURCE_JDBC_URL=jdbc:postgresql://host.docker.internal:5433/postgres alessandroamedei/users-service:TAG

### Swagger Open API address
    http://127.0.0.1:7001/swagger/

### Run tests
    mvn test

### Docker build image jvm
    mvn clean package
    docker build -f ./src/main/docker/Dockerfile.jvm -t alessandroamedei/users-service:TAG .

### Push update to hub.docker.com (after docker login)
    docker push alessandroamedei/users-service:TAG

### hub.docker.com image repo
    https://hub.docker.com/repository/docker/alessandroamedei/users-service

### Use docker compose

    version: '2'

    services:
        db:
            image: 'postgres'
            container_name: 'users-db'
            environment:
             - POSTGRES_PASSWORD=postgres

        app:
            image: 'alessandroamedei/users-service:1'
            container_name: 'users-service'
            environment:
             - QUARKUS_DATASOURCE_JDBC_URL=jdbc:postgresql://db:5432/postgres
            depends_on:
             - db
            ports:
             - "7001:7001"

# users-service Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory. Be aware that it’s not an _über-jar_ as
the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/users-service-1-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- Hibernate ORM ([guide](https://quarkus.io/guides/hibernate-orm)): Define your persistent model with Hibernate ORM and
  JPA
- JDBC Driver - PostgreSQL ([guide](https://quarkus.io/guides/datasource)): Connect to the PostgreSQL database via JDBC

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
