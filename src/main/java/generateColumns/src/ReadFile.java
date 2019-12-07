package generateColumns.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author wangguangle
 * @date 2019/12/6 21:29
 */
public class ReadFile {
    public static String readFileContent(String fileName) throws IOException {
        File file = new File(fileName);
        /*if(!file.exists()) {
            file.createNewFile();
        }*/
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
            }
            reader.close();
            return sbf.toString().replace(";", "; ").replace("{", " { ").replace("}", " } ").replace("public", " public").replace("@", " @");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        System.out.println("-------------" + sbf.toString());
        return sbf.toString().replace(";", "; ").replace("{", " { ");

    }
}
