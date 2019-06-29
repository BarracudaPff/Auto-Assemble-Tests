FROM openjdk:8-jdk-alpine
COPY . /app
WORKDIR /app
RUN ./gradlew assemble-tests:fixedJar
ENTRYPOINT ["java", "-jar", "/app/assemble-tests/build/libs/Auto-Assemble-Tests-fixed-0.0.1.jar"]
