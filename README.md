# qas-service
Questions &amp; Answers Service

### Check All Tasks
`./gradlew tasks --all`

### Reload IntelliJ IDEA project
`./gradlew cleanIdea idea`

### Run clean and build tasks
`./gradlew clean build`, will auto create database

### Run unit test
`./gradlew test`, it depends on `build` task.

### Run integration test
`./gradlew integrationTest` or `./gradlew iT`, it depends on `build` task.

### Run build exclude integration test
`./gradlew build -x integrationTest` or `./gradlew build -x iT`

### Run checkstyle
`./gradlew check`

### Run code coverage check
`./gradlew checkTestCoverage`, it depends on `build` task.
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

Already used the H2 embedded database, no need to follow below steps:

1. Should Install Mysql in local
2. Create schema using script in `create_db.sql`

Or just run:
`./gradlew createDB`, dependsOn `./gradlew clean`

drop database:
`./gradlew dropDB`

#### Commands tips:
- Run `./gradlew flywayRepair` to repair the Flyway metadata table
- `./gradlew clean` depends on task `flywayRepair`

- Run `./gradlew flywayMigrate` to migrate the schema to the latest version
- `./gradlew build` depends on task `flywayMigrate`

- Run `./gradlew bootRun` will auto check and load the new db.migration scripts

- **Warning: Only know what you are doing: ** Run `./gradlew flywayClean` to drops all objects in the configured schema

[More about using flyway](https://flywaydb.org/documentation/gradle/): `flywayInfo`, `flywayValidate`, `flywayBaseline`

### Build Dockerfile
Build docker image using gradle:
`./gradlew buildDocker`

Build docker image and push to `twwee/qas-service`:
`./gradlew buildDocker -Ppush`

Build docker image using docker:
`cp build/libs/qas-service-0.1.0.jar docker && cd docker`

`docker build .`

If run service using docker:
`docker run -p 8086:8086 -t twwee/qas-service`

#### Using Docker Compose
Firstly, goto the docker directory:
`cd docker`

Run Docker Compose:
`docker-compose up`

If want to run in background:
`docker-compose up -d`

Check the status:
`docker-compose ps`

Stop docker services:
`docker-compose stop`

View the logs (press CTRL+C to exit):
`docker-compose logs`

Kill the containers and remove them:
```
docker-compose kill
docker-compose rm -f
```

More options:
`docker-compose --help`

If on Mac and using default docker-machine, try to hit:
[http://192.168.99.100:8086/qas-service/swagger-ui.html](http://192.168.99.100:8086/qas-service/swagger-ui.html)
