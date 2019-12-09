package generateColumns.src;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author wangguangle
 * @date 2019/12/6 21:43
 */
@Component
public class JustDoIT {
    private static final Logger logger = LoggerFactory.getLogger(JustDoIT.class);
    /**
     * 多条执行并记录
     *
     * @throws Exception
     */
    public static void doFiles(ArrayList<String> files) throws Exception {
        if (files.size() == 0) {
            logger.info("--------------------------失败--------------------" +files);
            return;
        }
        int i = 1, count = 0;
        String success = " ";
        String fail = " ";
        for (String file : files) {
            if (file != null && file != "") {
                String s = ReadFile.readFileContent(file);
                GenerateColumns.generating(s, file);
                logger.info("---------------------第" + i + "次-----------------成功----------------------");
                count += 1;
                success += i + " / ";
            } else {
                logger.info("--------------------第" + i + "次-----------------失败---------------------");
                fail += i + " / ";
            }
            i++;
        }
        logger.info("----------------------共成功" + count + "次-----------------失败" + (i - count - 1) + "次-------------------");
        logger.info("---------------------第" + success + "次成功--------------- --第" + fail + "次失败----------------------");
    }

    public static void doFile(String file) throws Exception {
        System.out.println("-------------------------------------start---------------------!");
        //需要格式的文件地址
        String oldFile = "D:\\project\\generateColumns\\src\\main\\java\\generateColumns\\src\\OutPutVO.java";
        if (file == null) {
            file = oldFile;
        }
        String s = ReadFile.readFileContent(file);
        GenerateColumns.generating(s, null);
        System.out.println("--------------------------------------END---------------------!");
    }
}
