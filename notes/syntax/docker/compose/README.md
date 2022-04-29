##### docker-compose -f a-docker-compose-file.yml up -d

后台启动指定文件包含的服务

##### docker-compose -f a-docker-compose-file.yml stop

停止一个compose文件中的所有服务

##### docker-compose -f a-docker-compose-file.yml down

停止这些服务, 并删除响应的容器

> 有段时间总是把 -f 这个 option 放在后面导致执行错误, 一度怀疑 docker-compose 是不是坏掉了

