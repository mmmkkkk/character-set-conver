/*************************************************
 Version: [公用提示信息/v0.0.1]
 Description:  提供一些公共的显示提示信息的方法
 History:  
 [2019/12/14] – [mk] - Created
 [日期] - [修改者] - Modify [修改描述]
 *************************************************/
package cn.bulaoerhuoblog.conver.common.util;

import java.io.*;
/**
 * 可复用的提示信息输出
 * 常用提示信息的汇总
 *
 * @author mk
 * @since V0.0.1
 */
public class InfomationUtil {
    public static void printHelpCommand() {
        System.out.println("输入以下命令获得提示:");
        System.out.println("java CharacterSetConver -help");
    }

    public static void helpInfo() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(InfomationUtil.class.getClassLoader().getResourceAsStream("help/help.txt"), "UTF-8"));
            String line = null;
            while (null != (line = br.readLine())) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

