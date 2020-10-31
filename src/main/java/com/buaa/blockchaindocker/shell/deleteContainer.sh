#!/bin/bash
#这是一个删除docker容器的文件
#sudo docker delete {containerName}
containerName=$1
echo "yhb13579"|sudo -S docker rm -f $containerName