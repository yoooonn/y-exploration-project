#!/usr/bin/env bash
#author yooonn

set -eux

./mvnw clean package -pl "$@" -am -Pbase-include

./mvnw com.spotify:dockerfile-maven-plugin:build -f "$*""/pom.xml"

exit 0
