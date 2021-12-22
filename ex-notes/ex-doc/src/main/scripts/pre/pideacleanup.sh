#!/usr/bin/env sh
# author: yongjiang

RED=$(tput setaf 1)
GREEN=$(tput setaf 2)
BLUE=$(tput setaf 4)
RESET=$(tput sgr0)

set -eu


if [ $# -lt 1 ]
then
  echo "${RED}Usage:${RESET} $0 PROJECT_DIR"
  exit 1
fi

projectDir=$1

if [ -d "$projectDir" ]
then
  cd "$projectDir" || exit 1
else
  echo "Directory not exist: $projectDir"
  exit 1
fi

if []

mvn clean

rm -rf .idea

find . -name "*.iml" -print0 | xargs -0 rm -f