import com.sun.javafx.scene.transform.TransformUtils;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2019/12/5.
 */
public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String s = "浜戝崡鐪佹槅鏄庡競鐜";
        String a = getEncoding(s);
        String newContent = new String(s.getBytes(),getEncoding(s));
        System.out.println(isMessyCode(s));
        System.out.println(newContent);

    }
//    public static  boolean isSimple(String str){
//        for (char c : str.toCharArray()) {
//            if(c >= 0x4e00 && c<= 0x9fa5){
//                return true;
//            }
//        }
//        return false;
//    }


    public static boolean isMessyCode(String str){
        Properties properties = new Properties(System.getProperties());
        String property = properties.getProperty("file.encoding");
//        if(!property.equals(getEncoding(str)) || isPartMessy(str)){
//            return true;
//        }
        if(getEncoding(str).contains("GB") || getEncoding(str).equals("UTF-8")){
            if(!isPartMessy(str)){
                return false;
            }
        }

        return true;
    }
    public static String getEncoding(String str){
        String[] strs = new String[]{"GB2312","ISO-8859-1","ASCII","UTF-8","GB18030","Unicode","Shift_JIS"};
        for (String encode : strs) {
            try {
                if(str.equals(new String(str.getBytes(encode),encode))){
                    return encode;
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
    /**
     * 判断是否是中日韩文字
     *
     * @param c 要判断的字符
     * @return true或false
     */
    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }


    /**
     * 判断是否是数字或者是英文字母
     *
     * @param c
     * @return
     */
    public static boolean judge(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')) {
            return true;
        }
        return false;
    }

    public static boolean isPartMessy(String strName) {
        //去除字符串中的空格 制表符 换行 回车
        Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");
        Matcher m = p.matcher(strName);
        String after = m.replaceAll("");
        //去除字符串中的标点符号
        String temp = after.replaceAll("\\p{P}", "");
        //处理之后转换成字符数组
        char[] ch = temp.trim().toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            //判断是否是数字或者英文字符
            if (!judge(c)) {
                //判断是否是中日韩文
                if (!isChinese(c)) {
                    //如果不是数字或者英文字符也不是中日韩文则表示是乱码返回true
                    return true;
                }
            }
        }
        //表示不是乱码 返回false
        return false;
    }


}
