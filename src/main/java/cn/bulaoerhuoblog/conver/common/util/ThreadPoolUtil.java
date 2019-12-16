/*************************************************
 Version: [线程池/v0.0.1]
 Description:  
 History:  
 [2019/12/15] – [mk] - Created
 [日期] - [修改者] - Modify [修改描述]
 *************************************************/

package cn.bulaoerhuoblog.conver.common.util;

import cn.bulaoerhuoblog.conver.api.argsparsing.Conver;
import cn.bulaoerhuoblog.conver.common.model.Args;
import cn.bulaoerhuoblog.conver.constant.ThreadPoolConsts;
import cn.bulaoerhuoblog.conver.service.conver.CharsetConver;
import cn.bulaoerhuoblog.conver.service.threadpool.ignorepolicy.LogIngorePolicy;
import cn.bulaoerhuoblog.conver.service.threadpool.task.FileSerach;
import cn.bulaoerhuoblog.conver.service.threadpool.threadfactory.NameThreadFactory;

import java.io.File;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 用于创建线程池的工具类
 * 提供创建线程池的方法
 *
 * @author mk
 * @since V0.0.1
 */
public class ThreadPoolUtil {
    public static ThreadPoolExecutor getDefaultThreadPool() {
        // 线程工厂
        NameThreadFactory nameThreadFactory = new NameThreadFactory();
        // 拒绝策略
        LogIngorePolicy logger = new LogIngorePolicy();

        ThreadPoolExecutor service = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(10), nameThreadFactory, logger);
        return service;
    }

    public static void batch(ThreadPoolExecutor service,LinkedBlockingQueue<File> tasks, Args arguments, Conver conver) {
        while (!tasks.isEmpty()) {
            File temp = tasks.poll();
            if (temp.isFile()) {
                service.execute(new FileSerach(temp, arguments, service, conver));
            } else {
                for (File file : temp.listFiles()) {
                    // 如果是目录，添加到队列
                    if (file.isFile()) {
                        service.execute(new FileSerach(file, arguments, service, conver));
                    } else {
                        try {
                            tasks.put(file);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

