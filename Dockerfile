#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package


#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/spring-boot-health-0.0.1-SNAPSHOT.jar /usr/local/lib/spring-boot-health.jar
EXPOSE 8443
ENTRYPOINT ["java","-jar","/usr/local/lib/spring-boot-health.jar"]
