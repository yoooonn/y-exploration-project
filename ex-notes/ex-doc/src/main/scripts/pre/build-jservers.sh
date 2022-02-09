#!/usr/bin/env bash
# author: yongjiang

RED=$(tput setaf 1)
GREEN=$(tput setaf 2)
BLUE=$(tput setaf 4)
RESET=$(tput sgr0)

set -eu

# Usage: build-jserver ProjectName Env ContainerIp HostIp

writeServerScript() {

  if [ -e "templates" ]; then
    if [ -d "templates" ]; then
      cd templates
    fi
  else
    echo "Please put jserver templates to ./templates directory"
    exit 1
  fi

  if [ -e "jserver" ]; then
    mkdir -p ../stages/"$1"
    cp jserver ../stages/"$1"/jserver
  else
    echo "Please give jserver template files"
    exit 1
  fi

  cd ../stages/"$1"
  find . -name jserver -print0 | xargs -0 perl -pi -e "s/PROJECT_NAME/$1/g"
  find . -name jserver -print0 | xargs -0 perl -pi -e "s/CONTAINER_IP/$3/g"
  find . -name jserver -print0 | xargs -0 perl -pi -e "s/HOST_IP/$4/g"

  mv jserver "$1$2"

  chmod 775 "$1$2"

  printf "\n"
  echo "Generate stages about $1 $2, you can do next command to use:"

  printf "sudo mkdir -p /usr/local/Manual/scripts && sudo cp -n $(pwd)/%s /usr/local/Manual/scripts/%s && sudo chown $(whoami) /usr/local/Manual/scripts/%s && sudo ln -s ../Manual/scripts/%s /usr/local/bin/%s\n" "$1$2" "$1$2" "$1$2" "$1$2" "$1$2"
  exit 0
}

if [ "$#" -lt 4 ]; then
  echo "${GREEN}Usage:$RESET build-jservers ProjectName Env ContainerIp HostIp"
  exit 1
fi

project="$1"
env="$2"
containerIp="$3"
hostIp="$4"

printf "${GREEN}You will setting jump server script about ${GREEN}project: ${RED}%s${GREEN}, env: ${RED}%s${GREEN}, container ip: ${RED}%s${GREEN}, host ip: ${RED}%s${RESET}\n" "${project}" "${env}" "${containerIp}" "${hostIp}"

if [[ -n "${project}" && -n "${env}" && -n "${containerIp}" && -n "${hostIp}" ]]; then
  echo "yes/no (no)? "
  read -r input
  if [[ -n "${input}" && ("y" == "${input}" || "yes" == "${input}") ]]; then
    writeServerScript "${project}" "${env}" "${containerIp}" "${hostIp}"
  else
    echo "Bye..."
  fi
else
  echo "Please trying with project, host ip and container ip..."
fi
