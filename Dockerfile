FROM public.ecr.aws/amazoncorretto/amazoncorretto:21

ARG JAR_FILE=target/*.jar
ARG PORT=8080

# Create non-root user (Amazon Linux compatible)
RUN groupadd spring && useradd -g spring spring

WORKDIR /app

COPY ${JAR_FILE} app.jar

RUN chown -R spring:spring /app

USER spring:spring

EXPOSE ${PORT}

ENTRYPOINT ["java", "-jar", "app.jar"]