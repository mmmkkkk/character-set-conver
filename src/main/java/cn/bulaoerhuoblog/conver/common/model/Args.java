/*************************************************
 Version: [参数模型/v0.0.1]
 Description:  
 History:  
 [2019/12/14] – [mk] - Created
 [日期] - [修改者] - Modify [修改描述]
 *************************************************/
package cn.bulaoerhuoblog.conver.common.model;

import java.util.StringJoiner;

/**
 * 参数模型
 * 用于保存解析后的参数
 *
 * @author mk
 * @since V0.0.1
 */
public class Args {


    /*
    源目录 需要转换的文件所在的目录
     */
    private String sourcePath;

    /*
    目标目录 转换后的文件存放的目录
     */
    private String targetPath;

    /*
    源编码 源文件的编码格式
     */
    private String sourceCharSet;

    /*
    目标文件的编码
     */
    private String targetCharSet;

    /*
    是否上送help参数
     */
    private boolean help;

    private boolean error;

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public String getTargetPath() {
        return targetPath;
    }

    public void setTargetPath(String targetPath) {
        this.targetPath = targetPath;
    }

    public String getSourceCharSet() {
        return sourceCharSet;
    }

    public void setSourceCharSet(String sourceCharSet) {
        this.sourceCharSet = sourceCharSet;
    }

    public String getTargetCharSet() {
        return targetCharSet;
    }

    public void setTargetCharSet(String targetCharSet) {
        this.targetCharSet = targetCharSet;
    }

    public boolean isHelp() {
        return help;
    }

    public void setHelp(boolean help) {
        this.help = help;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Args.class.getSimpleName() + "[", "]")
                .add("sourcePath='" + sourcePath + "'")
                .add("targetPath='" + targetPath + "'")
                .add("sourceCharSet='" + sourceCharSet + "'")
                .add("targetCharSet='" + targetCharSet + "'")
                .add("help=" + help)
                .add("error=" + error)
                .toString();
    }
}

