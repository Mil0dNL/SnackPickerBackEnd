FROM openjdk:17

COPY target/snackpickerbackend.jar snackpickerbackend.jar

ENTRYPOINT ["java", "-jar", "/snackpickerbackend.jar"]