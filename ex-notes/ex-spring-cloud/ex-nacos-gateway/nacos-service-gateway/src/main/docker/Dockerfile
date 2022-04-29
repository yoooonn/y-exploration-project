FROM openjdk:8-jdk-alpine

RUN echo 'Asia/Shanghai' >/etc/timezone

ENV NACOS_SERVER_ADDR ${NACOS_SERVER_ADDR}

ARG JAR_FILE

WORKDIR /home

ADD target/${JAR_FILE} ./app.jar

EXPOSE 18085

ENTRYPOINT ["java",\
"-Dspring.cloud.nacos.server-addr=${NACOS_SERVER_ADDR}", \
"-jar","/home/app.jar" \
]
