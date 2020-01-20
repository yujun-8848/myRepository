import java.util.Arrays;

/**
 * Created by Administrator on 2019/12/17.
 */
public class Test4 {

    public static void main(String[] args) {
        String s = "swef.sdf.sdf.sd,sd";
        String[] split = s.split("[\\.]");
        System.out.println(Arrays.toString(split));



    }

}
