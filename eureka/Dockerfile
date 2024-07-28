## gradle builder
FROM gradle:8.9.0-jdk21-alpine as builder
WORKDIR /eureka
COPY . .
RUN gradle build -x test

## java runtime
#FROM amazoncorretto:17.0.8-alpine3.18
FROM ghcr.io/graalvm/jdk-community:21

LABEL application="eureka"
LABEL version="1.0"
LABEL authors="HS"

ARG ARTIFACT_ID=eureka
ARG ARTIFACT_VERSION=0.0.1

EXPOSE 8761

WORKDIR /myserver
COPY --from=builder /eureka/build/libs/${ARTIFACT_ID}-${ARTIFACT_VERSION}-SNAPSHOT.jar ./app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]