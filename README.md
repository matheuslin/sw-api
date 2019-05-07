# SW API - Implementation
This project is the Coding Challenge part of a Recruiting process I'm taking as of 2019-05.

## Requirements for the Coding Challenge
* Build a REST API
* It should contain Planet data from the Star Wars universe.
    * this data can be obtained from Star Wars API (https://swapi.co)
* Each planet must contain:
    * Name
    * Climate
    * Terrain
    * Film Count (how many films this planet appears on)
* Desired functionalities:
    * Add a new Planet (with Name, Climate and Terrain)
    * List all Planets on the database
    * List all Planets from Star Wars API
    * Search by Planet Name in the Database
    * Search by Planet ID in the Database
    * Remove a Planet
* Languages:
    * Java
    * Kotlin
* Databases:
    * DynamoDB
    * Cassandra
    * MySQL
    * Oracle
* Diferentials:
    * Use some Reactive Framework (Spring WebFlux, VertX)

## Running the project
* building:
```
mvn clean package
```

* runing:
```
mvn spring-boot:run
```
This will start the application on `localhost:8080`.

The following endpoints are available:

Method | Target | Description
-------|--------|------------
`GET` | `/planets` | lists all planets available in the Database
`GET` | `/planets/swid` | returns only the planets with a SWID (that is, that were automatically filled from SWAPI when the application started)
`GET` | `/planets/id/{id}` | returns the Planet with the `id` ID. It is an UUID.
`GET` | `/planets/name/{name}` | returns the Planet with the exact `name` provided.
`POST` | `/planets` | adds a new planet to the database. The body of the `POST` request should contain a JSON with the fields `name` (string), `climate` (string), `terrain` (strign) and `filmCount` (integer).
`DELETE` | `/planets/id/{id}` | removes the Planet with the provided ID (`id`). _Just like Kamino was deleted from the Jedi Archives, as Darth Sidious' plot to start the Clone Wars!_

### Example usage:
The class `Application` has example of those endpoints usage.

## Implementation details
This project uses the **Java** language and the **Spring WebFlux** framework. It is intended to use the **Cassandra** database soon, but, while this does not happen, it uses a `Java Concurrent Map` as the Planet repository.

When run, the initial script (`Application.java`) does the following:
1. it fetches all Planets data from Star Wars API and stores them in the Repository, to populate the "initial Database".
1. it adds a sample planet, without the SWID parameter and writes the new Planet data on Terminal
1. it retrieves all planets, like the `GET /planets` endpoint and writes on Temrminal
1. it retrieves only the Planets with a SWID, like the `GET /planets/swid` endpoint, and writes on Terminal
1. it retrieves a Planet by name (Kamino) and writes it on Terminal
1. it deletes a Planet by ID (the one obtained for Kamino, above) from the Database

Thus, after the initial script run, the Database is expected to be:
* 61 Planets count (as of 2019-05-06, this is the current Planet count)
* Kamino is **NOT** on the Database
* An extra Planet is on the Database (the only one without SWID)