/*************************************************
 Version: [文件搜索/v0.0.1]
 Description:  
 History:  
 [2019/12/15] – [mk] - Created
 [日期] - [修改者] - Modify [修改描述]
 *************************************************/

package cn.bulaoerhuoblog.conver.service.threadpool.task;

import cn.bulaoerhuoblog.conver.api.argsparsing.Conver;
import cn.bulaoerhuoblog.conver.common.model.Args;
import cn.bulaoerhuoblog.conver.constant.ThreadPoolConsts;

import java.io.File;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * [一句话功能描述]
 * [功能详细描述，可多行]
 *
 * @author mk
 * @since V0.0.1
 */
public class FileSerach extends Thread {

    //    private LinkedBlockingDeque<File> fileList = new LinkedBlockingDeque(120);
    private File filePath;
    private Args arg;
    private ThreadPoolExecutor service;
    private Conver conver;

    public FileSerach(File filePath, Args arg, ThreadPoolExecutor service, Conver conver) {
        this.filePath = filePath;
        this.arg = arg;
        this.service = service;
        this.conver = conver;
    }

    @Override
    public void run() {
        if (filePath.isDirectory()) {
            for (File file : filePath.listFiles()) {
                // 如果是目录，添加到队列
                if (filePath.isDirectory()) {
                    if (service.getActiveCount() > ThreadPoolConsts.CORE_THREAD_NUM) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    service.execute(new FileSerach(file, arg, service, conver));
                } else {
                    // 如果是文件，转换
                    System.out.println("文件: " + filePath.getAbsoluteFile() + "strt");
                    conver.convert(arg, filePath);
                    System.out.println("文件: " + filePath.getAbsoluteFile() + "end");
                }
            }
        } else {
            // 如果是文件，转换
            System.out.println("文件: " + filePath.getAbsoluteFile());
            conver.convert(arg, filePath);
        }

    }
}

