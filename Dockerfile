FROM openjdk:17
ADD build/libs/gor-world.jar gor-world.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","gor-world.jar"]