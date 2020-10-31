#!/bin/bash
#这是一个强行停止docker容器的文件
#sudo docker kill {containerName}
containerName=$1
echo "yhb13579"|sudo -S docker kill $containerName