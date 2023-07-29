# Stage 1: Build the Java application
FROM gradle:6.8.0-jdk8 AS build

# Copy the project files into the container
COPY . /src

# Set the working directory to the root of the project
WORKDIR /src

# Build the Java application using Gradle
RUN gradle build

# Stage 2: Create the final container
FROM openjdk:8-jre-slim

# Install necessary packages for X11
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    libxext6 libxtst6 libxrender1 libxi6

# Set the environment variable to use the host's X11 server
ENV unset DISPLAY:10.0

# Enable X11 forwarding by sharing the X11 Unix socket with the container
# Mount the host's X11 socket to /tmp/.X11-unix inside the container
# This will allow the container to use the host's X11 server
VOLUME /tmp/.X11-unix

# Expose the port that the application will listen on (adjust this according to your application's requirements)
EXPOSE 8970

# Create a directory for the application
RUN mkdir /app

# Copy the built Java application JAR from the previous stage into the container
COPY --from=build /src/lib/build/libs/lib-1.jar /app/lib-1.jar

# Set the working directory to the application directory
WORKDIR /app

# Start the Java application with the X11 display support
CMD ["java", "-jar", "/app/lib-1.jar"]
