FROM maven:3.8.1-adoptopenjdk-11 as BUILD
WORKDIR /usr/src/app
COPY pom.xml .
RUN mvn --batch-mode --errors --strict-checksums --threads 1C org.apache.maven.plugins:maven-dependency-plugin:3.1.2:go-offline
COPY . .
RUN mvn --batch-mode --errors --threads 1C verify

FROM openjdk:11-jre
COPY --from=BUILD /usr/src/app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]