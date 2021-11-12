#!/usr/bin/env sh
# author: yongjiang

. color-header

# functions
printCurrentBranch() {
    echo "${GREEN}current branch: ${BLUE}$1${RESET}"
}

# contents
currentBranchName=$(git symbolic-ref --short HEAD)

printCurrentBranch "${currentBranchName}"

./mvnw -s ~/.m2/normal-settings.xml clean -pl "$@" -am

exit 0
