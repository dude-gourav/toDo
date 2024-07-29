FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/toDo-0.0.1-SNAPSHOT.jar todo.jar
ENTRYPOINT ["java", "-jar", "/toDo.jar"]