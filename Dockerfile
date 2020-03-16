FROM mysql:5.7
FROM java:8
EXPOSE 8080
ADD /target/springbootdb-0.0.1-SNAPSHOT.jar springbootdb-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","springbootdb-0.0.1-SNAPSHOT.jar"]