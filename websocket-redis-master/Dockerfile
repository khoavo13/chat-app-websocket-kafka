FROM openjdk:11-jdk-oracle
WORKDIR /app
COPY target/kafka-demo.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]