FROM openjdk:11
ADD /target/spring-snils-validator.jar spring-snils-validator.jar
ENTRYPOINT ["java", "-jar", "spring-snils-validator.jar"]
ENV JAVA_OPTS="-XX:+UseG1GC, -server"