#!/usr/bin/env sh
# author: yooonn

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

./mvnw clean compile -Pbase-include

exit 0
