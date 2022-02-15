FROM  maven:3-jdk-11

WORKDIR /my-app
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run