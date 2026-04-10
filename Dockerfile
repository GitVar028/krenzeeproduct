# Use the official Lambda base image (includes the Runtime Interface Client)
FROM public.ecr.aws/lambda/java:21

# Lambda base image uses /var/task as the working directory by default
WORKDIR /var/task

# Copy your compiled code and dependencies from CodeBuild
COPY target/classes/ ./
COPY target/dependency/ ./lib/
EXPOSE 8080
# This now works because this image knows how to execute Java handlers
CMD ["com.krayzee.krenzeeproduct.adapter.configuration.StreamLambdaHandler::handleRequest"]