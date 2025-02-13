FROM openjdk:17
EXPOSE:8080
ADD target/user_service_oct24-0.0.1-SNAPSHOT.jar user_service_oct24-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/user_service_oct24-0.0.1-SNAPSHOT.jar"]