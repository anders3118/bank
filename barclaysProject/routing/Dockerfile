FROM openjdk
ENV SERVER_PORT=9222
COPY /target/routing-*.jar /app/BarclaysRoutingServices.jar
EXPOSE $SERVER_PORT
CMD ["java", "-jar", "/app/BarclaysRoutingServices.jar"]
