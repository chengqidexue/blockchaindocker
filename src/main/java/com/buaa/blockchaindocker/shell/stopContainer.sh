#!/bin/bash
#这是一个停止docker容器的文件
#sudo docker stop {containerName}
containerName=$1
echo "yhb13579"|sudo -S docker stop $containerName