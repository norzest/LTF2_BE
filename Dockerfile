FROM openjdk:8
ARG JAR_FILE=build/libs/app.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]