FROM openjdk:8-jdk-alpine
COPY . /app
WORKDIR /app
RUN ./gradlew docker
ENTRYPOINT ["java", "-jar", "/app/build/libs/Auto-Assemble-Tests-fixed-0.0.1.jar"]
