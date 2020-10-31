#!/bin/bash
#这是一个运行docker容器的文件
#sudo docker run --name {containerName} {imageName}
#sudo docker run --name {containerName} {imageName}:{tag}
containerName=$1
imageName=$2
tag=""
if [ $# == 3 ]; then
    tag=$3
else tag="latest"
fi
echo "yhb13579"|sudo -S docker run --name $containerName $imageName:$tag