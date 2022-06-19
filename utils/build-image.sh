#!/usr/bin/env bash
#author yooonn

RED=$(tput setaf 1)
GREEN=$(tput setaf 2)
BLUE=$(tput setaf 4)
RESET=$(tput sgr0)

# functions
printCurrentBranch() {
    echo "${GREEN}current branch: ${BLUE}$1${RESET}"
}

# contents
currentBranchName=$(git symbolic-ref --short HEAD)

printCurrentBranch "${currentBranchName}"

./mvnw spring-boot:build-image  -pl "$@" -am -Dspring-boot.build-image.imageName=ycourlee/eureka-single

exit 0
