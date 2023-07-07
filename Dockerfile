FROM openjdk:17

WORKDIR /usr/src/app

ARG JAR_PATH=./build/libs

COPY ${JAR_PATH}/sangboo-0.0.1-SNAPSHOT.jar ${JAR_PATH}/sangboo-0.0.1-SNAPSHOT.jar

CMD ["java","-jar","./build/libs/sangboo-0.0.1-SNAPSHOT.jar"]