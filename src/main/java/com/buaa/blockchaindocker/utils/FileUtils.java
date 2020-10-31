package com.buaa.blockchaindocker.utils;

import java.io.*;
import java.util.List;

import com.buaa.blockchaindocker.entity.ContainerAndDynamicCode;

public class FileUtils {
    /**
     * 将动态码映射表存到该目录下
     */
    private static final String dynamicRootPath = "/home/haibo/table";

    /**
     * 将对象保存到相应路径的文件里面
     * 
     * @param obj      需要保存的对象
     * @param fileName 文件名
     * @return true：保存成功 false:保存失败
     */
    public static boolean writeObjectToFile(Object obj, String fileName) {
        StringBuilder filePath = new StringBuilder(FileUtils.dynamicRootPath + "/" + fileName);
        File file = new File(filePath.toString());
        FileOutputStream out;
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            out = new FileOutputStream(file);
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeObject(obj);
            objOut.flush();
            objOut.close();
            System.out.println("write object success!");
            return true;
        } catch (Exception e) {
            System.out.println("write object failed");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 从文件中取出对象
     * 
     * @param fileName 文件名
     * @return object：返回对象 null：返回空
     */
    public static Object readObjectFromFile(String fileName) {
        Object temp = null;
        StringBuilder filePath = new StringBuilder(FileUtils.dynamicRootPath + "/" + fileName);
        File file = new File(filePath.toString());
        FileInputStream in;
        try {
            in = new FileInputStream(file);
            ObjectInputStream objIn = new ObjectInputStream(in);
            temp = objIn.readObject();
            objIn.close();
            System.out.println("read object success!");
        } catch (IOException e) {
            System.out.println("read object failed");
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return temp;
    }

    /**
     * 判断算法文件是否存在
     * @param fileName  算法文件location
     * @return  true:存在 false：不存在
     */
    public static boolean algorithmFileIsExist(String fileName) {
        StringBuilder filePath = new StringBuilder(fileName);
        File file = new File(filePath.toString());
        return file.exists();
    }

    /**
     * 判断数据文件s是否存在
     * @param fileNames 数据文件locations
     * @return true:存在 false：不存在
     */
    public static boolean dataFilesIsExist(List<String> fileNames) {
        for (String fileName : fileNames) {
            StringBuilder filePath = new StringBuilder(fileName);
            File file = new File(filePath.toString());
            if (!file.exists()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    //     ContainerAndDynamicCode containerAndDynamicCode = new ContainerAndDynamicCode(
    //            "containerName", "dynamicCode1234", "imageName");
    //    if (FileUtils.writeObjectToFile(containerAndDynamicCode,
    //            containerAndDynamicCode.getContainerName()+containerAndDynamicCode.getDynamicCode())) {
    //        System.out.println("OK");
    //    }
    //    else {
    //        System.out.println("No");
    //    }
       Object object = FileUtils.readObjectFromFile("dockercreatetest");
       if (object != null) {
           System.out.println((ContainerAndDynamicCode) object);
       } 
       else {
           System.out.println("No");
       }
    }
}
