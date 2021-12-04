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

    // 所有贴纸stickers，每一种贴纸都有无穷张
    // target
    // 最少张数
    public static int process(String[] stickers, String target) {
        if (target.length() == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (String str : stickers) {
            String rest = valied(str, target);
            if (rest.length() != target.length()) {
                min = Math.min(min, process(stickers, rest));
            }
        }
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }

    public static String valied(String str, String target) {
        char[] str1 = str.toCharArray();
        char[] str2 = target.toCharArray();
        int[] count = new  int[26];
        for (char c : str2) {
            count[c -'a']++;
        }
        for (char c : str1) {
           count[c-'a']--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            if(count[i] > 0){
                for (int j = 0; j < count[i]; j++) {
                    sb.append((char)( i + 'a'));
                }
            }
        }
        return sb.toString();
    }

}
