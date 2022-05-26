#!/usr/bin/env sh
# author: yooonn

RED=$(tput setaf 1)
GREEN=$(tput setaf 2)
BLUE=$(tput setaf 4)
RESET=$(tput sgr0)

# -e 命令运行失败，脚本立即退出执行
# -u 如果存在未声明（赋值）的变量，脚本立即退出执行
# -x 启用跟踪（调试）模式，识别语法错误和逻辑错误，显示所有执行的命令、参数和结果
set -eu

module=$1

cp "${module}" ~/.source/luaLib/

echo "${GREEN}${module}${RESET} installed."
