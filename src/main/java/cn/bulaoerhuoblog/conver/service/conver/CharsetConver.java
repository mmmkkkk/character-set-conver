/*************************************************
 Version: [编码转换/v0.0.1]
 Description:  
 History:  
 [2019/12/15] – [mk] - Created
 [日期] - [修改者] - Modify [修改描述]
 *************************************************/
package cn.bulaoerhuoblog.conver.service.conver;

import cn.bulaoerhuoblog.conver.api.argsparsing.Conver;
import cn.bulaoerhuoblog.conver.common.model.Args;
import cn.bulaoerhuoblog.conver.common.util.CommonUtil;
import cn.bulaoerhuoblog.conver.constant.ArgsConsts;

import java.io.FileInputStream;
import java.io.*;

/**
 * 编码转换
 * 编码转换
 *
 * @author mk
 * @since V0.0.1
 */
public class CharsetConver implements Conver {

    @Override
    public void convert(Args arg, File sourceFile) {
        String sourcePath = arg.getSourcePath();
        String targetPath = arg.getTargetPath();
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {

            // 获取绝对路径
            String sourceFileAbsPath = sourceFile.getAbsolutePath();
            // 获取相对路径
            String relativePath = sourceFileAbsPath.substring(sourcePath.length());
            File targetFile = new File(targetPath + relativePath);
            if (!targetFile.exists()){
                File parentFile = targetFile.getParentFile();
                if(!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                targetFile.createNewFile();
            }
            if (ArgsConsts.AUTO_IDENTIFY_SOURCE_CHARSET.equalsIgnoreCase(arg.getSourceCharSet())) {
                // 自动识别源文件编码
                // TODO 2019/12/15 10:13 mk:自动识别文件编码功能
            }
            if (CommonUtil.isNull(arg.getTargetCharSet())) {
                arg.setTargetCharSet(ArgsConsts.DEFAULT_TARGET_CHARSET);
            }

            // 创建BufferedReader
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile), arg.getSourceCharSet()));
            // 创建BufferedWriter
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetFile), arg.getTargetCharSet()));
            String line = null;
            while (null != (line = reader.readLine())) {
                writer.write(line);
                writer.newLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != writer) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

