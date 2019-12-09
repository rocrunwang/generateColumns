package generateColumns.src;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;

/**
 * 解析过滤有效文件
 *
 * @author wangguangle
 * @date 2019/12/9 9:29
 */
public class GetAllFiles {
    private static final Logger logger = LoggerFactory.getLogger(JustDoIT.class);

    public static ArrayList<String> dirAllStrArr = new ArrayList<>();
    public static ArrayList<String> dirAllFail = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        String dir = "D:\\project\\generateColumns\\src\\main\\java\\generateColumns/";
        File f = new File(dir);
        DirAll(f);
    }

    /**
     * 多文件夹过滤
     *
     * @param dirFiles
     * @return
     */
    public static ArrayList<String> filesAllList(ArrayList<String> dirFiles) {
        try {
            for (String dirFile : dirFiles) {
                DirAll(new File(dirFile));
            }
            if (dirAllStrArr == null || dirAllStrArr.size() == 0) {
                return null;
            }
            logger.info("过滤后有效路径 ：" + dirAllStrArr);
            logger.info("无效路径：" + dirAllFail);

        } catch (Exception e) {
            logger.info("多文件夹过滤失败 ：" + e);
            return null;
        }
        return dirAllStrArr;
    }

    /**
     * 单文件夹过滤
     *
     * @param dirFile
     * @return
     * @throws Exception
     */
    public static ArrayList<String> filesAll(String dirFile) throws Exception {
        DirAll(new File(dirFile));
        if (dirAllStrArr == null || dirAllStrArr.size() == 0) {
            return null;
        }
        return dirAllStrArr;
    }

    /**
     * 过滤文件夹中文件
     *
     * @param dirFile
     * @throws Exception
     */
    public static void DirAll(File dirFile) throws Exception {

        if (dirFile.exists()) {
            if (dirFile.isFile()) {
                dirAllStrArr.add(dirFile.getPath());
                return;
            } else if (dirFile.isDirectory()) {
                File files[] = dirFile.listFiles();
                for (File file : files) {
                    //如果遇到文件夹则递归调用。
                    if (file.isDirectory()) {
                        // 递归调用
                        DirAll(file);
                    } else {
                        //如果遇到文件则放入数组
                        putInDir(dirFile, file);
                    }
                    logger.info("所有文件：" + dirAllStrArr);
                }
            }
        } else {
            dirAllFail.add(dirFile.toString());
        }
    }

    /**
     * 如果遇到文件则放入数组
     */
    static void putInDir(File dirFile, File file) {
        try {
            if (dirFile.getPath().endsWith(File.separator)) {
                dirAllStrArr.add(dirFile.getPath() + file.getName());
            } else {
                dirAllStrArr.add(dirFile.getPath() + File.separator + file.getName());
            }
        } catch (Exception e) {
            logger.info("解析失败--路径：" + dirFile + "-------文件:" + file);
        }
    }
}
