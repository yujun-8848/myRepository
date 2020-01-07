import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created by Administrator on 2019/12/6.
 */
public class Test2 {

    public static void main(String[] args) {

        System.out.println(getEncoding("浜戝崡鐪佹槅鏄庡競瑗垮北鍖哄贰娲38鍙?骞?鍗曞厓301鍙"));
        System.out.println(isMess("浜戝崡鐪佹槅鏄庡競瑗垮北鍖哄贰娲38鍙?骞?鍗曞厓301鍙"));
    }


    public static boolean isMess(String str){
        Properties properties = new Properties(




        );
        String property = properties.getProperty("file.encoding");
        if(!property.equals(getEncoding(str))){
            return true;
        }
        return false;
    }
    public static String getEncoding(String str){
        String[] strs = new String[]{"GB2312","ISO-8859-1","GBK","ASCII","UTF-8","GB18030","Unicode","Shift_JIS"};
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

}
