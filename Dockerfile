FROM openjdk:17
EXPOSE 8181
COPY target/user-service-oct4-new-image.jar user-service-oct4-new-image.jar
ENTRYPOINT ["java", "-jar", "/user-service-oct4-new-image.jar"]