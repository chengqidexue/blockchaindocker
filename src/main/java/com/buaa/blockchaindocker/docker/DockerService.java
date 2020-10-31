package com.buaa.blockchaindocker.docker;

import com.buaa.blockchaindocker.Error.ProjectGetError;
import com.buaa.blockchaindocker.entity.ContainerAndDynamicCode;
import com.buaa.blockchaindocker.entity.Project;
import com.buaa.blockchaindocker.utils.DockerJavaUtils;
import com.buaa.blockchaindocker.utils.FileUtils;

import java.util.LinkedList;
import java.util.Queue;

public class DockerService {
    /**
     * 任务队列
     */
    private Queue<Project> JobQueueToDo = new LinkedList<>();

    public DockerService(Queue<Project> jobQueueToDo) {
        JobQueueToDo = jobQueueToDo;
    }

    public DockerService() {
    }

//    /**
//     * 创建Docker
//     * @return
//     */
//    private boolean dockerCreate() throws Exception{
//        CreateContainerResponse container = new CreateContainerResponse();
//        Project toDoProject = JobQueueToDo.poll();
//
//        if (toDoProject == null) {
//            throw new ProjectGetError();
//        }
//        else {
//            //TODO: 1、创建容器
//            //设置容器名直接为任务的任务动态码
//            String containerName = toDoProject.getDynamicCode();
//
//            //目前只能是事先构造好镜像了，然后在通过镜像构造容器
//            String imageName = "";
//
//            DockerClient client = DockerJavaUtils.connectDocker();
//            container = DockerJavaUtils.createContainers(client, containerName, imageName);
//
//            //TODO: 2、登记到动态码映射表 动态码映射表是我们自己维护吗?
//            //动态码映射表文件将对象保存到指定的目录下，文件名为 (动态码)
//            ContainerAndDynamicCode containerAndDynamicCode = new ContainerAndDynamicCode(containerName,
//                    container.getId(),
//                    toDoProject.getDynamicCode(),
//                    imageName);
//            FileUtils.writeObjectToFile(containerAndDynamicCode,
//                    containerAndDynamicCode.getContainerName()+containerAndDynamicCode.getDynamicCode());
//
//            //TODO: 3、调用dataRequire()函数
//
//            //TODO: 4、调用dataGet()函数
//
//        }
//        return true;
//    }
//
//    /**
//     * 删除容器
//     * @param dynamicCode   任务的动态码
//     * @param stopPatter    停止方式
//     */
//    private void dockerDelete(String dynamicCode, int stopPatter) {
//        //TODO: 1、通过动态码从表中查到容器id
//        Object object = FileUtils.readObjectFromFile(dynamicCode);
//        if (object == null) {
//            return;
//        } else {
//            //获取容器id
//            ContainerAndDynamicCode containerAndDynamicCode = (ContainerAndDynamicCode) object;
//            String containerId = containerAndDynamicCode.getContainerID();
//
//            //TODO: 2、删除容器;
//            DockerClient client = DockerJavaUtils.connectDocker();
//            DockerJavaUtils.removeContainer(client, containerId);
//        }
//    }
//
//
//    private boolean computeResultSend(Project project) {
//        //TODO: 1、检验数据文件和算法合约文件
//        //判断算法文件是否存在
//        if (!FileUtils.algorithmFileIsExist(project.getAlgorithmFilePath())) {
//            return false;
//        }
//
//        //判断数据文件是否存在
//        if (!FileUtils.dataFilesIsExist(project.getDataFilePaths())) {
//            return false;
//        }
//
//        //TODO: 2、启动执行算法合约文件
//        //先找到容器id
//        Object object = FileUtils.readObjectFromFile(project.getDynamicCode());
//        if (object == null) return false;
//        ContainerAndDynamicCode containerAndDynamicCode = (ContainerAndDynamicCode) object;
//        String containerId = containerAndDynamicCode.getContainerID();
//        String containerName = containerAndDynamicCode.getContainerName();
//
//        DockerClient client = DockerJavaUtils.connectDocker();
//        DockerJavaUtils.startContainer(client, containerId);
//
//        //TODO: 3、将结果发送至BlockData主题中，以动态码为tag
//
//        //TODO: 4、任务完成后，向该Tag发送算法执行结束消息。
//
//        //TODO: 5、在数据文件生命周期表中更新该任务的状态，占用任务数目减1（无任务正在使用）。
//
//        //TODO: 在Docker与动态码映射表登记任务完成，以删除Docker容器
//        containerAndDynamicCode.setStatus(2);
//        FileUtils.writeObjectToFile(containerAndDynamicCode, containerAndDynamicCode.getDynamicCode());
//
//
//        return true;
//    }



}
