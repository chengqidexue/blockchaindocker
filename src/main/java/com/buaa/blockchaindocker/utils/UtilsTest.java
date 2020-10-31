package com.buaa.blockchaindocker.utils;

import java.io.File;

import com.buaa.blockchaindocker.entity.Project;

public class UtilsTest {
    public static void main(String[] args) {

        //Test CmdUtils.exeCmd()
        // File dir = new File("./src/main/java/com/buaa/blockchaindocker/shell/");
        // String cmd = "./deleteContainer.sh container2";
        // String result = CmdUtils.execCmd(cmd, dir);
        // System.out.println(result);


        //Test createDockerImage()
        // Project project = new Project(null, "/home/haibo/data/helloDocker.py", "txywoaini");
        // if (DockerJavaUtils.createDockerImage(project)) {
        //     System.out.println("yes");
        // } else {
        //     System.out.println("no");
        // }


        //Test startDockerImage()
//        String dynamicCode = "txyla";
//        String result = DockerJavaUtils.startContainer(dynamicCode);
//        System.out.println(result);

        //Test removeConatiner()
//        String dynamicCode = "txyla";
//        if (DockerJavaUtils.removeContainer(dynamicCode)) {
//            System.out.println("yes");
//        } else {
//            System.out.println("no");
//        }


//        Test stopContainer()
        // String dynamicCode = "jovial_serson";
        // if (DockerJavaUtils.stopContainer(dynamicCode)) {
        //     System.out.println("yes");
        // } else {
        //     System.out.println("no");
        // }

        //Test removeImage()
//        String dynamicCode = "yhb123456";
//        if (DockerJavaUtils.removeImage(dynamicCode)) {
//            System.out.println("yes");
//        } else {
//            System.out.println("no");
//        }


    }
}