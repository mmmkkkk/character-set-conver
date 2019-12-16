/*************************************************
 Version: [线程池/v0.0.1]
 Description:  
 History:  
 [2019/12/15] – [mk] - Created
 [日期] - [修改者] - Modify [修改描述]
 *************************************************/

package cn.bulaoerhuoblog.conver.common.util;

import cn.bulaoerhuoblog.conver.service.threadpool.ignorepolicy.LogIngorePolicy;
import cn.bulaoerhuoblog.conver.service.threadpool.threadfactory.NameThreadFactory;

import	java.util.concurrent.LinkedBlockingQueue;
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
    public static ThreadPoolExecutor getDefaultThreadPool(){
        // 线程工厂
        NameThreadFactory nameThreadFactory = new NameThreadFactory();
        // 拒绝策略
        LogIngorePolicy logger = new LogIngorePolicy();

        ThreadPoolExecutor service = new ThreadPoolExecutor(100,100,0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable> (50),nameThreadFactory,logger);
        return service;
    }
}

