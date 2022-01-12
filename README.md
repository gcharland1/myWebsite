# Code from a tutorial for Spring framework

## Configuring the API
1. Initiate a new empty postgreSQL database named `student` on port `5432`
2. Change lines 3 and 4 of `application.properties` to match you user and password of choice
    ```
    spring.datasource.username={myPostgreSQLUsername}
    spring.datasource.password={myPassword}
    ```
3. Change line 17 of `pom.xml` to match your Java Version
    ```
    <java.version>17</java.version>
    ```

## Installing and running the API
1. run `./mvnw clean` to make sure no `target/` folder exists
2. run `./mvnw install` to generate the application `.tar`files
3. navigate to `target/`
4. run `java -jar myWebsite-{version}-SNAPSHOT.jar [--server.port={Port number}]`

## Using the web API
There are 4 methods to the API
### GET METHOD
Navitage to `localhost:8080/api/v1/student` to consult all entries of the DataBase

### POST METHOD
`curl -X POST -H "Content-Type: application/json" -d '{"name": "myName", "dob": "1999-01-01", "email": "example@gmail.com"}' http://0.0.0.0:8080/api/v1/student`

creates a new student with attributes: 
* name = myName
* Date of Birth = "1999-01-01"
* email = example@gmail.com

### DELETE METHOD
`curl -X DELETE http://0.0.0.0:8080/api/v1/student/{id}`

This request will delete student with ID `{id}`.

### PUT METHOD
#### Change the name
`curl -X PUT http://0.0.0.0:8080/api/v1/student/{id}?name=newName`

Will change the name of student with ID `{id}` to `newName`

#### Change the email
`curl -X PUT http://0.0.0.0:8080/api/v1/student/{id}?email=newEmail`

Will change the email of student with ID `{id}` to `newEmail`


