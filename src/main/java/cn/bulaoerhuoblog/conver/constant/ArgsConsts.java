/*************************************************
 Version: [命令行参数解析/v0.0.1]
 Description:  
 History:  
 [2019/12/14] – [mk] - Created
 [日期] - [修改者] - Modify [修改描述]
 *************************************************/
package cn.bulaoerhuoblog.conver.constant;

/**
 * 参数相关常量
 * 用于定于与命令行参数相关的常量
 *
 * @author mk
 * @since V0.0.1
 */
public class ArgsConsts {
    /**
     * 默认的目标编码 UTF-8
     */
    public static final String DEFAULT_TARGET_CHARSET = "UTF-8";
    /**
     * 自动识别源文件编码格式的参数值
     */
    public static final String AUTO_IDENTIFY_SOURCE_CHARSET = "AUTO";
    /**
     * 参数名前缀
     */
    public static final String ARGS_NAME_PREFIX = "-";
    /**
     * 源文件路径参数名
     */
    public static final String SOURCE_PATH = "s";
    /**
     * 源文件编码参数名
     */
    public static final String SOURCE_CHARSET = "sc";
    /**
     * 目标文件路径参数名
     */
    public static final String TARGET_PATH = "t";
    /**
     * 目标文件编码参数名
     */
    public static final String TARGET_CHARSET = "tc";
    /**
     * help
     */
    public static final String HELP = "help";

}

