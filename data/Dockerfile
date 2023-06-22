FROM eclipse-temurin:17.0.7_7-jre-alpine as builder

ARG JAR_FILE=build/libs/*.jar
ARG APP_NAME=data.jar

WORKDIR /tmp
COPY $JAR_FILE $APP_NAME

RUN java -Djarmode=layertools -jar $APP_NAME extract

FROM eclipse-temurin:17.0.7_7-jre-alpine

ARG GROUP=group
ARG USER=user
RUN addgroup -S $GROUP && adduser -S $USER -G $GROUP
USER $USER

ARG BUILD_PATH=/tmp
WORKDIR /opt/data
COPY --from=builder $BUILD_PATH/dependencies/ ./
COPY --from=builder $BUILD_PATH/spring-boot-loader/ ./
COPY --from=builder $BUILD_PATH/snapshot-dependencies/ ./
COPY --from=builder $BUILD_PATH/application/ ./

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]