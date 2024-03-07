FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/srms-latest.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
