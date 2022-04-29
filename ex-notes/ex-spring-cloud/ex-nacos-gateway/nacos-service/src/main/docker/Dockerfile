FROM openjdk:8-jdk-alpine

RUN echo 'Asia/Shanghai' >/etc/timezone

ENV NACOS_SERVER_ADDR ${NACOS_SERVER_ADDR}
ENV REDIS_SERVER_HOST ${REDIS_SERVER_HOST}
ENV REDIS_SERVER_PORT ${REDIS_SERVER_PORT}
ENV DATASOURCE_HOST ${DATASOURCE_HOST}
ENV DATASOURCE_PORT ${DATASOURCE_PORT}
ENV DATASOURCE_PARAM ${DATASOURCE_PARAM}
ARG JAR_FILE

WORKDIR /home

ADD target/${JAR_FILE} ./app.jar

EXPOSE 8000

ENTRYPOINT ["java",\
"-Dspring.cloud.nacos.server-addr=${NACOS_SERVER_ADDR}", \
"-Dspring.redis.host=${REDIS_SERVER_ADDR}", \
"-Dspring.redis.port=${REDIS_SERVER_PORT}", \
"-Dcustom.datasource.host=${DATASOURCE_HOST}", \
"-Dcustom.datasource.port=${DATASOURCE_PORT}", \
"-Dcustom.datasource.param=${DATASOURCE_PARAM}", \
"-jar","/home/app.jar" \
]
