FROM openjdk:8-jdk-alpine
COPY . /app
WORKDIR /app
RUN ./gradlew core:fixedJar
ENTRYPOINT ["java", "-jar", "/app/core/build/libs/core-fixed-0.0.1.jar"]
