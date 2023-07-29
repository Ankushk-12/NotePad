FROM gradle:6.8.0-jdk8 AS build

COPY . /lib

WORKDIR /lib

COPY . /src

WORKDIR /src

RUN gradle build  
# RUN gradle fatJar  

FROM openjdk:8-jre-slim

EXPOSE 8970:8970

RUN mkdir /app

# COPY --from=build /src/src/main/resources app/

COPY --from=build /src/lib/build/libs/lib-1.jar /app/lib-1.jar

ENTRYPOINT ["java","-jar","/app/lib-1.jar"]