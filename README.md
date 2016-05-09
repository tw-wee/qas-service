# qas-service
Questions &amp; Answers Service


### Reload IntelliJ IDEA project
`./gradlew cleanIdea idea`

### Run clean and build tasks
`./gradlew clean build`

### Run unit test
`./gradlew test`

### Run integration test
`./gradlew integrationTest` or `./gradlew iT`

### Run build exclude integration test
`./gradlew build -x integrationTest` or `./gradlew build -x iT`

### Start Application
`./gradlew bootRun`

### Remote Debug
1. Edit Configurations -> Add New Configuration -> Remote -> set name as `RemoteDebug`, port as `5005` -> Apply/OK
2. Launch `./gradlew run --debug-jvm`
3. Choose `RemoteDebug` -> Debug

### Run checkstyle


### Run the JAR file
`java -jar build/libs/qas-service-0.1.0.jar`


### Check service health


### Load Swagger UI


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


