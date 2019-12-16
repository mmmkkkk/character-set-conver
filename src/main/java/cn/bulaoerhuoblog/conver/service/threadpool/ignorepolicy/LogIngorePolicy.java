/*************************************************
 Version: [线程池/v0.0.1]
 Description:  
 History:  
 [2019/12/15] – [mk] - Created
 [日期] - [修改者] - Modify [修改描述]
 *************************************************/

package cn.bulaoerhuoblog.conver.service.threadpool.ignorepolicy;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池拒绝策略
 * 打印被拒绝的线程
 *
 * @author mk
 * @since V0.0.1
 */
public class LogIngorePolicy implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        doLog(r);

    }

    private void doLog(Runnable r){
        System.out.println(r.toString() + " rejected");
    }
}

