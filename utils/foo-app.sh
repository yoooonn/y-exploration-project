#!/usr/bin/env bash
# author yooonn

RED=$(tput setaf 1)
GREEN=$(tput setaf 2)
BLUE=$(tput setaf 4)
RESET=$(tput sgr0)

start() {
    count="$1"
    if [ "${count}" -eq 1 ]; then
        touch logs/foo/1.log
        echo -n "" >logs/foo/1.log
        nohup java -jar ex-notes/ex-spring-boot/ex-foo-app/target/*.jar >logs/foo/1.log 2>&1 &
    elif [ "$1" -eq 2 ]; then
        touch logs/foo/1.log
        touch logs/foo/2.log
        echo -n "" >logs/foo/1.log
        echo -n "" >logs/foo/2.log
        nohup java -jar ex-notes/ex-spring-boot/ex-foo-app/target/*.jar >logs/foo/1.log 2>&1 &
        nohup java -jar ex-notes/ex-spring-boot/ex-foo-app/target/*.jar --server.port=8081 >logs/foo/2.log 2>&1 &
    elif [ "$1" -eq 3 ]; then
        touch logs/foo/1.log
        touch logs/foo/2.log
        touch logs/foo/3.log
        echo -n "" >logs/foo/1.log
        echo -n "" >logs/foo/2.log
        echo -n "" >logs/foo/3.log
        nohup java -jar ex-notes/ex-spring-boot/ex-foo-app/target/*.jar >logs/foo/1.log 2>&1 &
        nohup java -jar ex-notes/ex-spring-boot/ex-foo-app/target/*.jar --server.port=8081 >logs/foo/2.log 2>&1 &
        nohup java -jar ex-notes/ex-spring-boot/ex-foo-app/target/*.jar --server.port=8082 >logs/foo/3.log 2>&1 &
    else
        touch logs/foo/1.log
        echo -n "" >logs/foo/1.log
        nohup java -jar ex-notes/ex-spring-boot/ex-foo-app/target/*.jar >logs/foo/1.log 2>&1 &
    fi
}

stop() {
    jps | grep "ex-foo-app" | awk '{print $1}' | xargs kill
}

set -eu

serviceCount=1

if [ "$#" -lt 1 ]; then
    echo "Usage: UTIL [start [1,2,3] | stop]"
    exit 1
elif [ "$#" -ge 2 ]; then
    serviceCount=$2
fi

opt=$1

if [ "${opt}" = "start" ]; then
    ./mvnw clean package -pl ex-notes/ex-spring-boot/ex-foo-app -am
    mkdir -p logs/foo
    start "${serviceCount}"
elif [ "${opt}" = "stop" ]; then
    stop
else
    echo "Usage: UTIL [start [1,2,3] | stop]"
    exit 1
fi
