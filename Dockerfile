# FROM maven:3.8.1 AS MAVEN_BUILD
# COPY . .
# # RUN apt-get install -y maven
# RUN mvn clean install package -Dtestngxml=testng_Smoke.xml -DskipTests
# FROM openjdk:8-jre-alpine3.9
# ARG PROJECT
# COPY --from=MAVEN_BUILD /target/automation-mrp-jar-with-dependencies.jar /automation-mrp-jar-with-dependencies.jar
# CMD java -jar automation-mrp-jar-with-dependencies.jar
# # # CMD mvn test -Dtestngxml=testng_Smoke.xml

# # FROM openjdk:11
# # LABEL maintainer="mrp-qa"
# # ADD /target/automation-mrp.jar automation-mrp.jar
# # ENTRYPOINT [ "java", "-jar", "automation-mrp.jar" ]


# FROM maven:3.5.4-jdk-8-alpine as maven
# COPY ./pom.xml ./pom.xml
# COPY ./src ./src
# RUN mvn clean install
# FROM openjdk:8u171-jre-alpine
# WORKDIR /qa-testing
# COPY --from=maven target/automation-mrp-jar-with-*.jar ./automation-mrp-jar-with-dependencies.jar
# CMD ["java", "-jar", "./automation-mrp-jar-with-dependencies.jar"]


FROM  maven:3.6.0-jdk-8-alpine

COPY src /home/qa-testing/src

COPY pom.xml /home/qa-testing

COPY testng_Smoke.xml /home/qa-testing

RUN mvn -f /home/qa-testing/pom.xml clean test -DskipTests=true