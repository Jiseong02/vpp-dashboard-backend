FROM eclipse-temurin:21-jre-alpine

WORKDIR /vpp
COPY /build/libs/vpp-latest.jar /vpp.jar
ENTRYPOINT ["java","-jar","/vpp.jar"]