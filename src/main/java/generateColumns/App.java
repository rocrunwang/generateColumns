package generateColumns;

import generateColumns.com.GetAllFiles;
import generateColumns.com.JustDoIT;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

/**
 * Hello world!
 *
 * @author rocwang
 */
@SpringBootApplication
public class App {

    @SuppressWarnings("AlibabaRemoveCommentedCode")
    public static void main(String[] args) throws Exception {
//        SpringApplication.run(App.class, args);

        //需要格式的文件地址
        ArrayList<String> files = new ArrayList<>();
        files.add("D:\\project\\generateColumns\\src\\main\\java\\generateColumns\\com\\InPutVO.txt");
        files.add("D:\\project\\generateColumns\\src\\main\\java\\generateColumns\\com\\OutPutVO.java");
        files.add("");
        files.add("");
        //过滤出有效路径
        ArrayList<String> filesAllList = GetAllFiles.filesAllList(files);
        //批量格式化
        JustDoIT.doFiles(filesAllList);
    }
}
