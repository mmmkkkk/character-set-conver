package cn.bulaoerhuoblog.conver.service.conver;

import cn.bulaoerhuoblog.conver.api.argsparsing.Conver;
import cn.bulaoerhuoblog.conver.common.model.Args;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class CharsetConverTest {
    private Args args;
    private File sourceFile;
    @BeforeEach
    void setUp() {
        args = new Args();
        args.setSourcePath("E:\\test\\source");
        args.setTargetPath("E:\\test\\target");
        args.setSourceCharSet("GBK");
        args.setTargetCharSet("UTF-8");
        sourceFile = new File("E:\\test\\source\\test1.txt");
    }

    @Test
    void convert() {
        Conver conver = new CharsetConver();
        conver.convert(args,sourceFile);
    }
}