FROM quay.io/devfile/maven:3.3.3-jdk-8

WORKDIR /build

# Build dependency offline to streamline build
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src src
RUN mvn package -Dmaven.test.skip=true

FROM openjdk:11-jdk
COPY --from=0 /build/target/devops-groovy-products-ci-cd-os-0.0.1-SNAPSHOT.jar /app/target/devops-groovy-products-ci-cd-os-0.0.1-SNAPSHOT.jar

EXPOSE 8080






















ENTRYPOINT [ "java", "-jar", "/app/target/devops-groovy-products-ci-cd-os-0.0.1-SNAPSHOT.jar", "--server.port=8080" ]
