FROM openjdk:17-jdk-slim
ADD target/warehouse-0.0.1-SNAPSHOT.jar  warehouse-0.0.1-SNAPSHOT.jar
ENTRYPOINT  ["java","-jar","/warehouse-0.0.1-SNAPSHOT.jar"]