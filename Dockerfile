FROM public.ecr.aws/amazoncorretto/amazoncorretto:21

ARG JAR_FILE=target/*.jar
ARG PORT=8080

WORKDIR /app

COPY ${JAR_FILE} app.jar

# Optional but safer
RUN chown -R 1001 /app

# Run as non-root user (no need to create one)
USER 1001

EXPOSE ${PORT}

ENTRYPOINT ["java", "-jar", "app.jar"]