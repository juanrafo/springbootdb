FROM mysql:5.7
FROM adoptopenjdk/openjdk11:latest
EXPOSE 8090
ADD /target/springbootdb-0.0.2-SNAPSHOT.jar springbootdb-0.0.2-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","springbootdb-0.0.2-SNAPSHOT.jar"]