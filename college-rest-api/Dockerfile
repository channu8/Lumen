FROM java:8

WORKDIR /app
COPY . /app

EXPOSE 8080
ADD ./target/college-rest-api.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]