FROM anapsix/alpine-java
LABEL maintainer="pradeeepmurthy@gmail.com"
COPY /target/devops-groovy-products-ci-cd-os-0.0.1-SNAPSHOT.jar /home/devops-groovy-products-ci-cd-os-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","/home/devops-groovy-products-ci-cd-os-0.0.1-SNAPSHOT.jar"]