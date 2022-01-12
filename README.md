# Code from a tutorial for Spring framework

## Configuring website
1. Initiate a new empty postgreSQL database named `student` on port `5432`
2. Change lines 3 and 4 of `application.properties` to match you user and password of choice
    ```
    3. spring.datasource.username={myPostgreSQLUsername}
    4. spring.datasource.password={myPassword}
    ```

## Installing and running website
1. run `./mvnw clean` to make sure no `target/` folder exists
2. run `./mvnw install` to generate the application `.tar`files
3. navigate to `target/`
4. run `java -jar myWebsite-{version}-SNAPSHOT.jar [--server.port={Port number}]`