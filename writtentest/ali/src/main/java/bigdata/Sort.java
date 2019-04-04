package bigdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author YaboSun
 *
 * 同学阿里面试题，大数据排序问题
 *
 */
public class Sort {

    /**
     * 最简单想到的思路就是将文件进行切分
     *
     */
    public void bigDataSort() {

    }

    /**
     * 将给定大文件按一定规则切分为小文件
     * @param filePath 大文件所在路径
     * @param partPath 切分以后文件存放路径
     */
    private static void splitLargeFile(String filePath, String partPath) throws FileNotFoundException {
        // 根据给定的文件路径，创建文件对象
        File file = new File(filePath);

        FileInputStream fileInputStream = new FileInputStream(file);
    }
}
