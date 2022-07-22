#!/usr/bin/env bash
# author yooonn

set -eux

./mvnw -X -e clean package -pl "$@" -am

./mvnw -X -e com.spotify:dockerfile-maven-plugin:build -f "$*""/pom.xml"

exit 0
