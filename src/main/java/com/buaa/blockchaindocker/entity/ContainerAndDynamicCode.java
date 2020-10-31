package com.buaa.blockchaindocker.entity;

import java.io.Serializable;
import java.util.Date;

public class ContainerAndDynamicCode implements Serializable {
    private String containerName;                  //容器名以后就是我们唯一的标识符(=dynamicCodeContainer)
    private String containerID;                    //以后都用不到这个
    private String dynamicCode;
    private String imageName;
    private Integer status;     //0:运行；  1：停止；2：完成/清除
    private Date createdTime;   //创建时间
    private Integer memory;     //

    public ContainerAndDynamicCode() {
    }

    public ContainerAndDynamicCode(String containerName, String dynamicCode, String imageName, Integer status, Date createdTime, Integer memory) {
        this.containerName = containerName;
        this.containerID = "-1";
        this.dynamicCode = dynamicCode;
        this.imageName = imageName;
        this.status = status;
        this.createdTime = createdTime;
        this.memory = memory;
    }

    public ContainerAndDynamicCode(String containerName, String dynamicCode, String imageName, Integer status, Date createdTime) {
        this.containerName = containerName;
        this.containerID = "-1";
        this.dynamicCode = dynamicCode;
        this.imageName = imageName;
        this.status = status;
        this.createdTime = createdTime;
        this.memory = -1;   //初始化为-1
    }

    public ContainerAndDynamicCode(String containerName, String dynamicCode, String imageName, Integer status) {
        this.containerName = containerName;
        this.containerID = "-1";
        this.dynamicCode = dynamicCode;
        this.imageName = imageName;
        this.status = status;
        this.createdTime = new Date();  //默认当前时间
        this.memory = -1;   //初始化为-1
    }

    public ContainerAndDynamicCode(String containerName, String dynamicCode, String imageName) {
        this.containerName = containerName;
        this.containerID = "-1";
        this.dynamicCode = dynamicCode;
        this.imageName = imageName;
        this.status = 1;    //默认状态为停止
        this.createdTime = new Date();
        this.memory = -1;   //初始化为-1
    }

    public String getContainerName() {
        return containerName;
    }

    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    public String getContainerID() {
        return containerID;
    }

    public void setContainerID(String containerID) {
        this.containerID = containerID;
    }

    public String getDynamicCode() {
        return dynamicCode;
    }

    public void setDynamicCode(String dynamicCode) {
        this.dynamicCode = dynamicCode;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "ContainerAndDynamicCode{" +
                "containerName='" + containerName + '\'' +
                ", containerID='" + containerID + '\'' +
                ", dynamicCode='" + dynamicCode + '\'' +
                ", imageName='" + imageName + '\'' +
                ", status=" + status +
                ", createdTime=" + createdTime +
                ", memory=" + memory +
                '}';
    }
}
