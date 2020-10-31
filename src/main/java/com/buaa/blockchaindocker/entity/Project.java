package com.buaa.blockchaindocker.entity;

import java.util.ArrayList;

/**
 * JobQueueToDo中的需要处理的Job
 */
public class Project {
    private ArrayList<String> dataFilePaths;
    private String algorithmFilePath;
    private String dynamicCode;
    private Integer tempDataTransferredX;
    private Integer resultMaxSize;

    public Project() {
    }

    public Project(ArrayList<String> dataFilePaths, String algorithmFilePath, String dynamicCode, Integer tempDataTransferredX, Integer resultMaxSize) {
        this.dataFilePaths = dataFilePaths;
        this.algorithmFilePath = algorithmFilePath;
        this.dynamicCode = dynamicCode;
        this.tempDataTransferredX = tempDataTransferredX;
        this.resultMaxSize = resultMaxSize;
    }

    public Project(ArrayList<String> dataFilePaths, String algorithmFilePath, String dynamicCode, Integer tempDataTransferredX) {
        this.dataFilePaths = dataFilePaths;
        this.algorithmFilePath = algorithmFilePath;
        this.dynamicCode = dynamicCode;
        this.tempDataTransferredX = tempDataTransferredX;
        this.resultMaxSize = 1;
    }

    public Project(ArrayList<String> dataFilePaths, String algorithmFilePath, String dynamicCode) {
        this.dataFilePaths = dataFilePaths;
        this.algorithmFilePath = algorithmFilePath;
        this.dynamicCode = dynamicCode;
        this.tempDataTransferredX = -1;
        this.resultMaxSize = 1;
    }

    public ArrayList<String> getDataFilePaths() {
        return dataFilePaths;
    }

    public void setDataFilePaths(ArrayList<String> dataFilePaths) {
        this.dataFilePaths = dataFilePaths;
    }

    public String getAlgorithmFilePath() {
        return algorithmFilePath;
    }

    public void setAlgorithmFilePath(String algorithmFilePath) {
        this.algorithmFilePath = algorithmFilePath;
    }

    public String getDynamicCode() {
        return dynamicCode;
    }

    public void setDynamicCode(String dynamicCode) {
        this.dynamicCode = dynamicCode;
    }

    public Integer getTempDataTransferredX() {
        return tempDataTransferredX;
    }

    public void setTempDataTransferredX(Integer tempDataTransferredX) {
        this.tempDataTransferredX = tempDataTransferredX;
    }

    public Integer getResultMaxSize() {
        return resultMaxSize;
    }

    public void setResultMaxSize(Integer resultMaxSize) {
        this.resultMaxSize = resultMaxSize;
    }

    @Override
    public String toString() {
        return "Project{" +
                "dataFilePaths=" + dataFilePaths +
                ", algorithmFilePath='" + algorithmFilePath + '\'' +
                ", dynamicCode='" + dynamicCode + '\'' +
                ", tempDataTransferredX=" + tempDataTransferredX +
                ", resultMaxSize=" + resultMaxSize +
                '}';
    }
}
