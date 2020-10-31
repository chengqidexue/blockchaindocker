package com.buaa.blockchaindocker.utils;

import com.buaa.blockchaindocker.entity.CmdResult;
import com.buaa.blockchaindocker.entity.Project;

import java.io.File;

public class DockerJavaUtils {

    /**
     * shell文件存放的相对路径
     */
    public static final String shellPath = "./src/main/java/com/buaa/blockchaindocker/shell/";

    /**
     * 创建镜像
     *
     * @param project 得到任务后需要创建的额镜像
     * @return 返回镜像是否创建成功
     */
    public static boolean createDockerImage(Project project) {
        //需要执行的Linux命令
        StringBuilder cmd = new StringBuilder();

        //需要执行的算法文件名称
        String algorithmFileName = "";
        File algorithmFile = new File(project.getAlgorithmFilePath());
        if (!algorithmFile.exists()) {
            return false;
        } else {
            algorithmFileName = algorithmFile.getName();
        }
        //需要传入的参数有五个：
        //#1.dynamicCode 也作为工作目录文件夹名 也作为生成的镜像名
        //#2.算法合约文件的绝对路径
        //#3.createDockerfile.sh文件的绝对路径
        //#4.Base镜像名称FROM {BaseImage}
        //#5.算法文件的名称
        String dynamicCode = project.getDynamicCode();
        String algorithmFilePath = project.getAlgorithmFilePath();
        String createDockerfileShellPath = "../createDockerfile.sh";
        String baseImage = "python:3";

        cmd = cmd.append("./createImage.sh ").append(dynamicCode).append(" ").append(algorithmFilePath).append(" ")
                .append(createDockerfileShellPath).append(" ").append(baseImage).append(" ").append(algorithmFileName);
        File dir = new File(shellPath);
        CmdResult result = CmdUtils.execCmd(cmd.toString(), dir);
        System.out.println(result);
        return (result != null);
    }

    /**
     * 根据镜像名称创建一个容器并且启动
     *
     * @param dynamicCode 镜像名称
     * @return 返回执行的结果
     */
    public static CmdResult startContainer(String dynamicCode) {
        CmdResult result = new CmdResult();
        //需要执行的Linux命令
        //#sudo docker run --name {containerName} {imageName}               imageName = {dynamicCode}     containerName = {dynamicCode}Container
        //#sudo docker run --name {containerName} {imageName}:{tag}         If there is no "tag", then tag = "latest".
        StringBuilder cmd = new StringBuilder();
        File dir = new File(shellPath);
        cmd.append("./startContainer.sh ").append(dynamicCode).append("Container ").append(dynamicCode);
        result = CmdUtils.execCmd(cmd.toString(), dir);
        return result;
    }

    /**
     * 停止容器 #sudo docker stop {containerName}
     *
     * @param dynamicCode docker容器
     */
    public static boolean stopContainer(String dynamicCode) {
        StringBuilder cmd = new StringBuilder();
        String containerName = dynamicCode + "Container";
        File dir = new File(shellPath);
        cmd.append("./stopContainer.sh ").append(containerName);
        CmdResult result = CmdUtils.execCmd(cmd.toString(), dir);
        System.out.println(result);
        return (result != null);
    }

    /**
     * 删除容器 #sudo docker rm {containerName}
     *
     * @param dynamicCode 根据dynamicCode删除容器，containerName={dynamicCode}Container
     * @return 返回是否删除成功
     */
    public static boolean removeContainer(String dynamicCode) {
        String containerName = dynamicCode + "Container";
        StringBuilder cmd = new StringBuilder();
        File dir = new File(shellPath);
        cmd.append("./deleteContainer.sh ").append(containerName);
        CmdResult result = CmdUtils.execCmd(cmd.toString(), dir);
        System.out.println(result);
        return (result != null);
    }

    /**
     * 删除镜像 #sudo docker rmi {imageName}
     *
     * @param imageName 要删除的镜像名称{dynamicCode}
     * @return 是否删除成功
     */
    public static boolean removeImage(String imageName) {
        File dir = new File(shellPath);
        StringBuilder cmd = new StringBuilder();
        cmd.append("./deleteImage.sh ").append(imageName);
        CmdResult result = CmdUtils.execCmd(cmd.toString(), dir);
        System.out.println(result);
        return (result != null);
    }
}
