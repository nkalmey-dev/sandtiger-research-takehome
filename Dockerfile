FROM gradle:6.9-jdk8 AS build

WORKDIR /app
COPY . .
RUN gradle clean build --no-daemon

FROM amazoncorretto:8-alpine
WORKDIR /app
COPY --from=build /app/build/libs/sandtiger-research-takehome-1.0-SNAPSHOT.jar ./sandtiger-research-takehome.jar

CMD ["java", "-jar", "sandtiger-research-takehome.jar"]