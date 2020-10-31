package com.buaa.blockchaindocker.utils;

import com.buaa.blockchaindocker.entity.ContainerAndDynamicCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilsTest {

    @Test
    void writeObjectToFile() {
        ContainerAndDynamicCode containerAndDynamicCode = new ContainerAndDynamicCode(
                "nginx1", "123456", "project1", "nginx");
        if (FileUtils.writeObjectToFile(containerAndDynamicCode,
                containerAndDynamicCode.getContainerName()+containerAndDynamicCode.getDynamicCode())) {
            System.out.println("OK");
        }
        else {
            System.out.println("No");
        }
    }

    @Test
    void readObjectFromFile() {
        ContainerAndDynamicCode containerAndDynamicCode = new ContainerAndDynamicCode(
                "nginx1", "123456", "project1", "nginx");
        Object object = FileUtils.readObjectFromFile(containerAndDynamicCode.getContainerName()+containerAndDynamicCode.getDynamicCode());
        if (object != null) {
            System.out.println((ContainerAndDynamicCode) object);
        } else {
            System.out.println("No");
        }
    }
}