/*************************************************
 Version: [参数解析/v0.0.1]
 Description:  
 History:  
 [2019/12/14] – [mk] - Created
 [日期] - [修改者] - Modify [修改描述]
 *************************************************/
package cn.bulaoerhuoblog.conver.service.agrsparsing;

import cn.bulaoerhuoblog.conver.api.argsparsing.IArgsParsing;
import cn.bulaoerhuoblog.conver.common.model.Args;
import cn.bulaoerhuoblog.conver.common.util.CommonUtil;
import cn.bulaoerhuoblog.conver.constant.ArgsConsts;

/**
 * 参数解析
 * 解析上送的参数数组到Args中
 *
 * @author mk
 * @since V0.0.1
 */
public class ArgsParsingImpl implements IArgsParsing {
    @Override
    public Args parseArgs(String[] args) {
        // 参数模型
        Args result = new Args();
        result.setError(false);

        // 如果参数为null或空数组,打印提示信息
        if (null == args || 0 == args.length) {
            result.setError(true);
            return result;
        }

        // 当前处理的参数名
        String argName = null;
        // 循环处理参数数组
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

            if (i % 2 == 0) {
                // 如果奇数位置的参数不已"-"开头，则参数上送错误
                if (!arg.startsWith(ArgsConsts.ARGS_NAME_PREFIX)) {
                    result.setError(true);
                }
                argName = arg.substring(1);
                // 如果上送-help，设置标识并退出循环
                if (ArgsConsts.HELP.equalsIgnoreCase(argName)) {
                    result.setHelp(true);
                    break;
                }
            } else {
                switch (argName) {
                    // 源目录
                    case ArgsConsts.SOURCE_PATH:
                        result.setSourcePath(arg);
                        break;
                    // 目标存放目录
                    case ArgsConsts.TARGET_PATH:
                        result.setTargetPath(arg);
                        break;
                    // 源编码
                    case ArgsConsts.SOURCE_CHARSET:
                        result.setSourceCharSet(arg);
                        break;
                    // 目标编码
                    case ArgsConsts.TARGET_CHARSET:
                        result.setTargetCharSet(arg);
                        break;
                    // 如果上送的参数名没有定于，提示help信息
                    default:
                        result.setError(true);
                        break;
                }
            }

            // 如果有处理错误的数据 退出循环
            if (result.isError()) {
                break;
            }
        }

        if (!result.isError() && requiredCheck(result)) {
            result.setError(true);
        }

        return result;
    }

    /**
     * 对参数进行必输项检查
     * 检查参数中的必输项是否有值
     *
     * @param arguments 需要检查的对象
     * @return boolean
     * @author mk
     * @since v0.0.1
     */
    private static boolean requiredCheck(Args arguments) {
        boolean result = false;
        if (CommonUtil.isNull(arguments.getSourcePath())) {
            result = true;
        }
        if (CommonUtil.isNull(arguments.getTargetPath())) {
            result = true;
        }
        if (CommonUtil.isNull(arguments.getSourceCharSet())) {
            result = true;
        }
        if (CommonUtil.isNull(arguments.getTargetCharSet())) {
            result = true;
        }
        return result;
    }
}

