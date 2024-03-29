/*************************************************
 Version: [编码转换主程序/v0.0.1]
 Description: 转换文件编码格式
 History:
 [2019/12/14] – [mk] - Created
 [日期] - [修改者] - Modify [修改描述]
 *************************************************/
package cn.bulaoerhuoblog.conver;

import cn.bulaoerhuoblog.conver.api.argsparsing.IArgsParsing;
import cn.bulaoerhuoblog.conver.common.model.Args;
import cn.bulaoerhuoblog.conver.common.util.InfomationUtil;
import cn.bulaoerhuoblog.conver.common.util.ThreadPoolUtil;
import cn.bulaoerhuoblog.conver.service.agrsparsing.ArgsParsingImpl;
import cn.bulaoerhuoblog.conver.service.conver.CharsetConver;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 转换文件编码格式
 * 根据命令行参数获取需要转换的路径和转换后的存放目录
 * 以及原编码和目标编码
 * 使用原编码读取待转换目录下的所有文件依次转换为目标编码格式
 * 并保存到参数指定的存放目录
 *
 * @author mk
 * @since V0.0.1
 */
public class CharacterSetConver {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        if (null == args || 0 == args.length) {
            InfomationUtil.printHelpCommand();
        }

        // 获取解析器
        IArgsParsing argsParsing = new ArgsParsingImpl();
        // 解析参数
        Args arguments = argsParsing.parseArgs(args);
        // 解析结果判断
        if (arguments.isHelp()) {
            InfomationUtil.helpInfo();
            return;
        }
        if (arguments.isError()) {
            InfomationUtil.printHelpCommand();
            return;
        }

        // 处理文件
        ThreadPoolExecutor service = ThreadPoolUtil.getDefaultThreadPool();
        File sourceFile = new File(arguments.getSourcePath());
        LinkedBlockingQueue<File> tasks = new LinkedBlockingQueue<File> ();
        tasks.add(sourceFile);
        ThreadPoolUtil.batch(service,tasks,arguments,new CharsetConver());

        while (tasks.size() != 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
    }



}