/*************************************************
 Version: [产品/模块版本]
 Description:
 History:
 [2019/12/14] – [mk] - Created
 [日期] - [修改者] - Modify [修改描述]
 *************************************************/
package cn.bulaoerhuoblog.conver.common.util;

import java.util.List;

/**
 * [一句话功能描述]
 * [功能详细描述，可多行]
 *
 * @author mk
 * @since V0.0.1
 */
public class CommonUtil {

    /**
     * null判断
     * 返回参数是否是null
     *
     * @param object 需要检查的对象
     * @return boolean 如果上送参数为null返回true，空串和零长List返回true
     * @author mk
     * @since v0.0.1
     */
    public static boolean isNull(Object object) {
        // 如果为null，返回true
        if (null == object) {
            return true;
        }
        // 如果为空串，返回true
        if (object instanceof String) {
            if ("".equals(object)) {
                return true;
            }
        }
        // 如果为长度0的List，返回true
        if (object instanceof List) {
            return  0 == ((List) object).size();
        }
        return false;
    }

    public static boolean isNotNull(Object object){
        return !isNull(object);
    }
}

