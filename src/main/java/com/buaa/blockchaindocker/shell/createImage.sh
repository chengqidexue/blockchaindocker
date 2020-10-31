#!/bin/bash
#这个文件是执行一系列Linux命令,来build镜像
#需要传入的参数有五个：
#1.dynamicCode 也作为工作目录文件夹名 也作为容器名
#2.算法合约文件的绝对路径
#3.createDockerfile.sh文件的绝对路径
#4.Base镜像名称FROM {BaseImage}
#5.算法文件的名称
#5.算法文件的名称
workspace=$1                    #需要创建的文件夹名称
algorithmFilePath=$2            #算法文件的绝对路径
createDockerfileShellPath=$3    #创建dockerfile文件路径
imageName=$4
algorithmFileName=$5
mkdir $workspace
cd $workspace
cp $algorithmFilePath ./
cp $createDockerfileShellPath ./
./createDockerfile.sh $imageName $algorithmFileName
echo "yhb13579" | sudo -S docker build -t $workspace:latest .
cd ..
rm -rf $workspace