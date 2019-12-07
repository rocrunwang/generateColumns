package generateColumns;

import generateColumns.src.JustDoIT;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 * @author rocwang
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) throws Exception {
//        SpringApplication.run(App.class, args);

        //需要格式的文件地址
        String[] files = {"",
                "D:\\project\\generateColumns\\src\\main\\java\\generateColumns\\src\\InPutVO.txt",
                "D:\\project\\generateColumns\\src\\main\\java\\generateColumns\\src\\OutPutVO.java",
                ""};
        //批量格式化
        JustDoIT.doFiles(files);
    }
}
