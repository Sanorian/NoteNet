FROM openjdk:alpine
WORKDIR /backend
COPY . .
RUN apk update && apk add gradle
EXPOSE 8080
CMD ["./gradlew", "bootRun"]