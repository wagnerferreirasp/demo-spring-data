FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package

FROM tomcat:9.0-jre8-alpine
COPY --from=MAVEN_TOOL_CHAIN /tmp/target/demo-spring-data*.jar /usr/app/demo-spring-data.jar
WORKDIR /usr/app/
ENTRYPOINT java -jar demo-spring-data.jar
EXPOSE 8090