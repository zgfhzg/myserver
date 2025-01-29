## gradle builder
FROM gradle:8.9.0-jdk21-alpine as builder
WORKDIR /gateway
COPY . .
RUN gradle build -x test

## java runtime
FROM ghcr.io/graalvm/jdk-community:21

LABEL application="gateway"
LABEL version="1.0"
LABEL authors="HS"

ARG ARTIFACT_ID=gateway
ARG ARTIFACT_VERSION=0.0.1

EXPOSE 8081

WORKDIR /myserver
COPY --from=builder /gateway/build/libs/${ARTIFACT_ID}-${ARTIFACT_VERSION}-SNAPSHOT.jar ./gateway.jar

ENTRYPOINT ["java", "-DEUREKA_URI=${EUREKA}", "-DSERVER_DNS=${DNS}", "-jar", "/myserver/gateway.jar"]