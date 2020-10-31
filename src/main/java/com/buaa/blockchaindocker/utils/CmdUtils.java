package com.buaa.blockchaindocker.utils;

import com.buaa.blockchaindocker.entity.CmdResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.InputStreamReader;

public class CmdUtils {
    static Logger logger = LoggerFactory.getLogger(CmdUtils.class);
    /**
     * 执行系统命令, 返回执行结果
     *
     * @param cmd 需要执行的命令
     * @param dir 执行命令的子进程的工作目录, null 表示和当前主进程工作目录相同
     * @return null 执行出现错误  正确执行命令则返回result
     */
    public static CmdResult execCmd(String cmd, File dir){
        CmdResult result = new CmdResult();
        StringBuilder right = new StringBuilder();
        StringBuilder error = new StringBuilder();

        Process process = null;
        BufferedReader bufrIn = null;
        BufferedReader bufrError = null;

        try {
            // 执行命令, 返回一个子进程对象（命令在子进程中执行）
            process = Runtime.getRuntime().exec(cmd, null, dir);

            // 方法阻塞, 等待命令执行完成（成功会返回0）
            process.waitFor();

            // 获取命令执行结果, 有两个结果: 正常的输出 和 错误的输出（PS: 子进程的输出就是主进程的输入）
            bufrIn = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
            bufrError = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));

            // 读取输出
            String line = null;
            while ((line = bufrIn.readLine()) != null) {
                right.append(line).append('\n');
            }
            while ((line = bufrError.readLine()) != null) {
                error.append(line).append('\n');
            }

            result.setRightOutput(right);
            result.setErrorOutput(error);
            
            logger.info("运行cmd命令成功:" + cmd);
            logger.info(String.valueOf(result));

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("运行cmd命令错误:" + cmd);
            return null;
        }
        finally {
            closeStream(bufrIn);
            closeStream(bufrError);

            // 销毁子进程
            if (process != null) {
                process.destroy();
            }
        }
        // 返回执行结果
        return result;
    }

    private static void closeStream(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (Exception e) {
                // nothing
            }
        }
    }
}