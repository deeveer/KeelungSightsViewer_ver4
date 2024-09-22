LABEL authors="Deerufin"

FROM gradle:7.6.4-jdk-focal AS backend-build
WORKDIR /app
RUN gradle clean build -x test

FROM openjdk:17-jdk-alpine AS build
WORKDIR /app
COPY --from=backend-build /app/build/libs/*.jar app.jar

CMD ["java","-jar","/app/app.jar"]