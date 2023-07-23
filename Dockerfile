# syntax=docker/dockerfile:1

FROM maven:3.9.3-sapmachine-17

WORKDIR /app

EXPOSE 8080
COPY . .
RUN chmod +x ./mvnw 
RUN echo $PATH
ENV PATH="$PATH:/app"
RUN echo $PATH
CMD ["./mvnw", "spring-boot:run"]
