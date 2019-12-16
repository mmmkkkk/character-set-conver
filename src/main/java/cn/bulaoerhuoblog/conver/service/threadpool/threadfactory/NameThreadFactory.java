/*************************************************
 Version: [线程工厂/v0.0.1]
 Description:
 History:
 [2019/12/15] – [mk] - Created
 [日期] - [修改者] - Modify [修改描述]
 *************************************************/
package cn.bulaoerhuoblog.conver.service.threadpool.threadfactory;

import	java.util.concurrent.atomic.AtomicInteger;

import java.util.concurrent.ThreadFactory;

/**
 * 线程工厂
 * 给线程增加名字
 *
 * @author mk
 * @since V0.0.1
 */
public class NameThreadFactory implements ThreadFactory {
    private final  AtomicInteger NEXT_ID = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable r) {
        Thread thread =new Thread(r,"Thread " + NEXT_ID.getAndIncrement());
        return thread;
    }
}

