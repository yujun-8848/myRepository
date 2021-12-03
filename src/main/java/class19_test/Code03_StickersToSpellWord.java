package class19_test;

/**
 * @author yujun
 * @Description 给定一个字符串str，给定一个字符串类型的数组arr，出现的字符都是小写英文
 * arr每一个字符串，代表一张贴纸，你可以把单个字符剪开使用，目的是拼出str来
 * 返回需要至少多少张贴纸可以完成这个任务。
 * 例子：str= "babac"，arr = {"ba","c","abcd"}
 * ba + ba + c  3  abcd + abcd 2  abcd+ba 2
 * 所以返回2
 * @Date 2021/12/2
 */
public class Code03_StickersToSpellWord {


    public static int minStickers1(String[] stickers, String target) {
        int ans = process(stickers, target);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    //组成贴纸的面值数组中组成target的最小方法数
    public static int process(String[] stickers, String target) {
        if (target.length() == 0) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        for (String str : stickers) {
            String rest = valied(str, target);
            if (rest.length() != target.length()) {
                min = Math.min(min, process(stickers, rest));
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min + 1;


    }

    public static String valied(String str, String target) {
        return null;
    }

}
