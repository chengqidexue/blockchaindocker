#!/bin/bash
#这是一个重启docker容器的文件
#sudo docker restart {containerName}
containerName=$1
echo "yhb13579"|sudo -S docker restart $containerName
