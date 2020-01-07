import java.util.regex.Pattern;

/**
 * Created by Administrator on 2019/12/17.
 */
public class Test4 {

    public static void main(String[] args) {
        String s = "^([+]?86|0)?([1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][56])|([7][0-8])|([8][0-9])|([9][189]))[0-9]{8})$";
        String a = "8615397593373";
        boolean matches = Pattern.matches(s, a);
        System.out.println(matches);
    }

}
