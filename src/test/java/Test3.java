import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Administrator on 2019/12/10.
 */
public class Test3 {
    private static ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{2,3,4},{3,4,5}};
        System.out.println(Arrays.deepToString(nums));
        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }

    }

    public static <T> T string2Obj(String str, Class<T> clazz,Long s){
        if ( clazz == null){
            return null;
        }
        try {
            return clazz.equals(String.class)? (T) str :objectMapper.readValue(str,clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }



}
