package com.buaa.blockchaindocker.utils;

import com.buaa.blockchaindocker.entity.Project;
import org.junit.jupiter.api.Test;


class DockerJavaUtilsTest {

    @Test
    void testDockerJavaUtils(){
        Project project = new Project(null, "/home/haibo/data/helloDocker.py", "yhb123456");
        if (DockerJavaUtils.createDockerImage(project)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}