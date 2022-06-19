#!/usr/bin/env sh
# author: yooonn

. color-header

# functions
printCurrentBranch() {
    echo "${GREEN}current branch: ${BLUE}$1${RESET}"
}

# contents
currentBranchName=$(git symbolic-ref --short HEAD)

printCurrentBranch "${currentBranchName}"

./mvnw clean package -pl "$@" -am

exit 0
