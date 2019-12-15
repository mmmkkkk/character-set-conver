/*************************************************
 Version: [命令行参数解析/v0.0.1]
 Description:
 History:
 [2019/12/14] – [mk] - Created
 [日期] - [修改者] - Modify [修改描述]
 *************************************************/
package cn.bulaoerhuoblog.conver.api.argsparsing;

import cn.bulaoerhuoblog.conver.common.model.Args;

/**
 * 命令行参数解析接口
 * 对命令行上送参数进行解析的统一接口
 *
 * @author mk
 * @since V0.0.1
 */
public interface IArgsParsing {

    /**
     * 参数解析统一接口
     * @param args 上送参数数组
     * @return Args 解析后的参数模型
     */
    Args parseArgs(String[] args);
}
