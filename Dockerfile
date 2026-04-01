# Use AWS's official Corretto 25 Alpine image for a minimal footprint
FROM amazoncorretto:25-alpine-jdk

# Define arguments for flexibility
ARG JAR_FILE=target/*.jar
ARG PORT=8080

# Create a dedicated non-root user and group for ECS security
RUN addgroup -S spring && adduser -S spring -G spring

# Set the working directory
WORKDIR /app

# Copy the built JAR into the image
COPY ${JAR_FILE} app.jar

# Change ownership of the app directory to the non-root user
RUN chown -R spring:spring /app

# Switch to the non-root user
USER spring:spring

# Expose the port the app runs on
EXPOSE ${PORT}

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]