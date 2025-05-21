FROM eclipse-temurin:21-jre-alpine

WORKDIR /vpp-dashboard
COPY /build/libs/vpp-dashboard-latest.jar /vpp-dashboard.jar
ENTRYPOINT ["java","-jar","/vpp-dashboard.jar"]