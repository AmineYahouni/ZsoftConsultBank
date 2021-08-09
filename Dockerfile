FROM maven:3.8.1-openjdk-17-slim AS bank-build
WORKDIR /opt/bank
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests


FROM openjdk:17-jdk
ENV BANK_HOME /opt/bank
ENV DB_HOST=bank-db
ENV DB_PORT=5432
WORKDIR $BANK_HOME
ADD https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh wait-for-it.sh
RUN chmod +x ./wait-for-it.sh
COPY --from=bank-build $BANK_HOME/target/*-SNAPSHOT.jar $BANK_HOME/store.jar
ENTRYPOINT bash ./wait-for-it.sh -t 30 ${DB_HOST}:$DB_PORT -- java -jar store.jar --spring.profiles.active=docker
