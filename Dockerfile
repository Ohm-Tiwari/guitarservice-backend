FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/guitarservice-0.0.1-SNAPSHOT.jar guitarservice.jar
ENTRYPOINT ["java", "-jar", "guitarservice.jar"]