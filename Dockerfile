FROM adoptopenjdk:17-jre
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT["java","-jar","/app.jar"]
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]