# qas-service
Questions &amp; Answers Service

### Check All Tasks
`./gradlew tasks --all`

### Reload IntelliJ IDEA project
`./gradlew cleanIdea idea`

### Run clean and build tasks
`./gradlew clean build`

### Run unit test
`./gradlew test`, it depends on `build` task.

### Run integration test
`./gradlew integrationTest` or `./gradlew iT`, it depends on `build` task.

### Run build exclude integration test
`./gradlew build -x integrationTest` or `./gradlew build -x iT`

### Run checkstyle
`./gradlew check`

### Run code coverage check
`./gradlew jacocoTestReport`, it depends on `build` task.
To see the test coverage report: `open build/reports/jacoco/test/html/index.html`.

### Run findBugs


### Run sonar


### Start Application
`./gradlew bootRun`

### Remote Debug
1. Edit Configurations -> Add New Configuration -> Remote -> set name as `RemoteDebug`, port as `5005` -> Apply/OK
2. Launch `./gradlew run --debug-jvm`
3. Choose `RemoteDebug` -> Debug

### Run the JAR file
`java -jar build/libs/qas-service-0.1.0.jar`


### Check service health


### Load Swagger UI
[http://localhost:8086/qas-service/swagger-ui.html](http://localhost:8086/qas-service/swagger-ui.html)


### Database & Flyway Migration
1. Should Install Mysql in local
2. Create schema using script in `create_db.sql`

#### Commands tips:
- Run `./gradlew flywayRepair` to repair the Flyway metadata table
- `./gradlew clean` depends on task `flywayRepair`

- Run `./gradlew flywayMigrate` to migrate the schema to the latest version
- `./gradlew build` depends on task `flywayMigrate`

- Run `./gradlew bootRun` will auto check and load the new db.migration scripts

- **Warning: Only know what you are doing: ** Run `./gradlew flywayClean` to drops all objects in the configured schema

[More about using flyway](https://flywaydb.org/documentation/gradle/): `flywayInfo`, `flywayValidate`, `flywayBaseline`


