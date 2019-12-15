package cn.bulaoerhuoblog.conver.service.agrsparsing;

import cn.bulaoerhuoblog.conver.common.model.Args;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * 参数转换单元测试
 */
class ArgsParsingImplTest {
    private List<String[]> testData = new ArrayList<> ();
    private ArgsParsingImpl argsParsing = new ArgsParsingImpl();
    @BeforeEach
    void setUp() {
        // 创建测试数据
        // 1、null
        testData.add(null);
        // 2、长度为0的数组
        testData.add(new String[] {});
        // 3、包含未知参数的数组
        testData.add(new String[] {"-c","E:\\","-f","s"});
        // 4、参数名不以“-”做前缀
        testData.add(new String[] {"c","E:\\"});
        // 5、必输参数维输入
        testData.add(new String[] {"-s","E:\\","-t","E:\\","-sc","GBK"});
        // 6、help
        testData.add(new String[] {"-help"});
        // 7、正常情况
        testData.add(new String[] {"-s","E:\\","-t","E:\\","-sc","GBK","-tc","UTF_8"});
    }

    @AfterEach
    void tearDown() {

    }

    /**
     * null案例
     */
    @Test
    void parseArgsNull() {
        Args args = argsParsing.parseArgs(testData.get(0));
        assertTrue(args.isError());
    }

    /**
     * 零长数组案例
     */
    @Test
    void parseArgsZeroLength() {
        Args args = argsParsing.parseArgs(testData.get(1));
        assertTrue(args.isError());
    }

    /**
     * 未知参数名案例
     */
    @Test
    void parseArgsUnknownArgs() {
        Args args = argsParsing.parseArgs(testData.get(2));
        assertTrue(args.isError());
    }

    /**
     * 参数不以-做前缀案例
     */
    @Test
    void parseArgsPrefix() {
        Args args = argsParsing.parseArgs(testData.get(3));
        assertTrue(args.isError());
    }

    /**
     * 必输校验案例
     */
    @Test
    void parseArgsRequiredCheck() {
        Args args = argsParsing.parseArgs(testData.get(4));
        assertTrue(args.isError());
    }

    /**
     * 上送help参数数据案例
     */
    @Test
    void parseArgsHelp() {
        Args args = argsParsing.parseArgs(testData.get(5));
        assertTrue(args.isHelp());
    }

    /**
     * 正常数据案例
     */
    @Test
    void parseArgs() {
        Args args = argsParsing.parseArgs(testData.get(6));
    }
}