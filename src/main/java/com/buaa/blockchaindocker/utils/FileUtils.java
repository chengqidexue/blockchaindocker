package com.buaa.blockchaindocker.utils;

import java.io.*;
import java.util.List;

public class FileUtils {
    /**
     * 将动态码映射表存到该目录下
     */
    private static final String dynamicRootPath = "E:\\2020AutumnStudy\\BlockChianProject\\table";

    /**
     * 数据文件的根目录
     */
    private static final String dataRootPath = "";

    /**
     * 算法文件的根目录
     */
    private static final String algorithmRootPath = "";

    /**
     * 将对象保存到相应路径的文件里面
     * @param obj   需要保存的对象
     * @param fileName 文件名
     * @return  true：保存成功   false:保存失败
     */
    public static boolean writeObjectToFile(Object obj, String fileName) {
        StringBuilder filePath = new StringBuilder(FileUtils.dynamicRootPath + "/" + fileName);
        File file = new File(filePath.toString());
        FileOutputStream out;
        try {
            out = new FileOutputStream(file);
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeObject(obj);
            objOut.flush();
            objOut.close();
            System.out.println("write object success!");
            return true;
        } catch (IOException e) {
            System.out.println("write object failed");
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 从文件中取出对象
     * @param fileName  文件名
     * @return  object：返回对象     null：返回空
     */
    public static Object readObjectFromFile(String fileName)
    {
        Object temp = null;
        StringBuilder filePath = new StringBuilder(FileUtils.dynamicRootPath + "/" + fileName);
        File file = new File(filePath.toString());
        FileInputStream in;
        try {
            in = new FileInputStream(file);
            ObjectInputStream objIn=new ObjectInputStream(in);
            temp=objIn.readObject();
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
     * @param fileName  算法文件名称
     * @return  true:存在 false：不存在
     */
    public static boolean algorithmFileIsExist(String fileName) {
        StringBuilder filePath = new StringBuilder(FileUtils.algorithmRootPath + "/" + fileName);
        File file = new File(filePath.toString());
        return file.exists();
    }

    /**
     * 判断数据文件s是否存在
     * @param fileNames 数据文件名称
     * @return true:存在 false：不存在
     */
    public static boolean dataFilesIsExist(List<String> fileNames) {
        for (String fileName : fileNames) {
            StringBuilder filePath = new StringBuilder(FileUtils.dataRootPath + "/" + fileName);
            File file = new File(filePath.toString());
            if (!file.exists()) {
                return false;
            }
        }
        return true;
    }

}
