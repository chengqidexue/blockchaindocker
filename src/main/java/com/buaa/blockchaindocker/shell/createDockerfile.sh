#!/bin/bash
#这个文件将自动创建一个Dockerfile文件
#首先将此文件放在某个上下文目录下
#接着构建镜像即可
#1.FROM {imageName}       构建image基于的image
#2.WORKDIR {/work}
#3.VOLUME {/data}
#4.ENTRYPOINT {python3}    运行Python文件
#5.CMD ["/data/algorithm.py"]
#传入的参数:1.镜像名称;  2.文件名
imageName=$1
algorithmFileName=$2
touch Dockerfile
echo "FROM $imageName
WORKDIR /workspace
COPY $algorithmFileName /workspace
VOLUME /data
ENTRYPOINT [\"python3\"]
CMD [\"$algorithmFileName\"]" > Dockerfile