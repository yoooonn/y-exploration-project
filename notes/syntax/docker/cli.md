##### docker port CONTAINER PORT

查看CONTAINER容器的PORT端口的绑定情况

##### docker logs CONTAINER

查看CONTAINER容器的日志

##### docker logs -f CONTAINER

实时查看CONTAINER容器的日志

##### docker inspect CONTAINER

查看容器信息

##### docker login

登录docker

##### docker tag LOCAL_IMAGE:VERSION USERNAME/IMAGE:NEW_VERSION

若本地镜像不规范，可使用该命令规范化镜像tag，tag必须以用户名开头后跟斜杠，之后即可执行push命令

##### docker push USERNAME/IMAGE:NEW_VERSION

推送到docker服务器自己自己名下

- [ ] inspect,

##### docker network

```bash
$ docker network --help

Usage:  docker network COMMAND

Manage networks

Commands:
  connect     Connect a container to a network
  create      Create a network
  disconnect  Disconnect a container from a network
  inspect     Display detailed information on one or more networks
  ls          List networks
  prune       Remove all unused networks
  rm          Remove one or more networks

Run 'docker network COMMAND --help' for more information on a command.
```

常用 ls, create, connect, rm. 不过有容器连接的场景就说明多服务, 通常使用 compose, 因容器连接也都在docker compose文件中.

其中 docker network create 详情, 都可通过 --help 获取详情

```bash
$ docker network create --help

Usage:  docker network create [OPTIONS] NETWORK

Create a network

Options:
      --attachable           Enable manual container attachment
      --aux-address map      Auxiliary IPv4 or IPv6 addresses used by
                             Network driver (default map[])
      --config-from string   The network from which copying the configuration
      --config-only          Create a configuration only network
  -d, --driver string        Driver to manage the Network (default "bridge")
      --gateway strings      IPv4 or IPv6 Gateway for the master subnet
      --ingress              Create swarm routing-mesh network
      --internal             Restrict external access to the network
      --ip-range strings     Allocate container ip from a sub-range
      --ipam-driver string   IP Address Management Driver (default "default")
      --ipam-opt map         Set IPAM driver specific options (default map[])
      --ipv6                 Enable IPv6 networking
      --label list           Set CryptoAnnotationMetadata on a network
  -o, --opt map              Set driver specific options (default map[])
      --scope string         Control the network's scope
      --subnet strings       Subnet in CIDR format that represents a
                             network segment
```

