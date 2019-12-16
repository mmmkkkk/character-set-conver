/*************************************************
 Version: [转换/v0.0.1]
 Description:  
 History:  
 [2019/12/15] – [mk] - Created
 [日期] - [修改者] - Modify [修改描述]
 *************************************************/
package cn.bulaoerhuoblog.conver.api.argsparsing;

import cn.bulaoerhuoblog.conver.common.model.Args;

import java.io.File;

/**
 * 转换接口
 *
 * @author mk
 * @since V0.0.1
 */
public interface Conver {
    void convert(Args arg, File sourceFile);
}
