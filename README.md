# NeoREST

Requirements
---
- An active Neo4j deployment.
- Bolt connectivitie between the host of the NeoREST application and the neo4j Database
- Free port 8080 in the host of the NeoREST application

How to start the NeoREST application
---

- Run `mvn clean package` to build the application
- Modify the config.yml file to point to the active neo4j Database (URI, Username and Password)
- Start application with `java -jar target/NeoREST-1.0-SNAPSHOT.jar server config.yml`
- To check that your application is running enter url `http://localhost:8080`

Usage
---
The NeoREST application provides 2 operations:

###/Employee/List (GET)

Returns all :Employee nodes (hard limited to 25)


######Example cURL

```
curl "http://localhost:8080/Employee/List"
```

###/Employee/Add (GET)

Creates an :Employee node. Receives 2 (mandatory) parameters: id and name

######Example cURL

```
curl "http://localhost:8080/Employee/Add?id=1&name=Rodrigo%20Haces"
```
