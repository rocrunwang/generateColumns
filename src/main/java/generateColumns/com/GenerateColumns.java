package generateColumns.com;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author wangguangle
 * @date 2019/12/6 14:49
 */

public class GenerateColumns {
    private static final Logger logger = LoggerFactory.getLogger(JustDoIT.class);
    static File filePath = null;

    public static void generating(String data, String file) throws Exception {
        FileOutputStream fileWriter = makeDir(file);
        String[] arr = data.split("\\s+");
        for (String str : arr) {
            if (str.contains(";") && str.length() > 1) {
                str = filteUpper(str);
            }
            if (str.contains("_")) {
                str = filte(filteDouble(str).toLowerCase());
            }
            if (str.contains("private") || str.contains("public") || str.contains("protected") || str.contains("@") || str.contains(" * @") || str.contains("*/")) {
//                logger.info(System.lineSeparator());
                //打印到控制台
//                System.out.println(System.lineSeparator().charAt(0));
                fileWriter.write(System.getProperty("line.separator").getBytes());
            }
//            if (str.contains("VO") ||str.contains("QC")) {
//                str = "OutPutVO";
//            }
//            logger.info(str.replaceFirst("\n", " ") + " ");
//            System.out.print(str.replaceFirst("\n", " ") + " ");
            fileWriter.write((str.replaceFirst("\n", " ") + " ").getBytes());
            if (str.contains(";") || str.contains("{") || str.contains("}")) {
//                logger.info(System.lineSeparator());
//                System.out.println(System.lineSeparator().charAt(0));
                fileWriter.write(System.getProperty("line.separator").getBytes());
            }
        }
    }

    private static String filte(String str) {
        StringBuffer buffer = new StringBuffer(str);
        int length = str.length();
        int i = str.indexOf("_");
        if (length == 1) {
            return "";
        }
        if (i + 1 == length) {
            buffer.replace(i, i + 1, "");
            return buffer.toString();
        } else if (i < length - 1) {
            buffer.replace(i, i + 2, buffer.substring(i + 1, i + 2).toUpperCase());
            if (buffer.toString().contains("_")) {
                return filte(buffer.toString());
            }
        }
        return buffer.toString();
    }

    //过滤多个下划线
    private static String filteDouble(String str) {
        String replace = "";
        if (str.contains("__")) {
            replace = filteDouble(str.replace("__", "_"));
        } else {
            replace = str;
        }
        return replace;
    }

    //过滤大写
    private static String filteUpper(String str) {
        if (Character.isUpperCase(str.charAt(0))) {
            return str.toLowerCase();
        } else {
            return str;
        }
    }

    static FileOutputStream makeDir(String myFile) throws Exception {
        String file = "D:\\project\\generateColumns\\com\\main\\java\\generateColumns\\com\\OutPutVO.java";
        if (myFile == null) {
            myFile = file;
        }
        filePath = new File(myFile);
        if (!filePath.exists()) {
            filePath.createNewFile();
        }
        FileOutputStream fileWriter = new FileOutputStream(filePath);
        return fileWriter;
    }
  /*static DataOutputStream getWrite() throws Exception{
       filePath = new File("./com/main/java/generateColumns/Write.txt");
       if(!filePath.exists()) {
           filePath.createNewFile();
       }
      FileOutputStream fos=new FileOutputStream(filePath);
      DataOutputStream fileWriter=new DataOutputStream(fos);
      return  fileWriter;
  }*/
}
