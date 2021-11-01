package class02_test;

/**
 * @author yujun
 * @Description 一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这种数
 * @Date 2021/10/29
 */
public class Code02_EvenTimesOddTimes {

    // arr中，只有一种数，出现奇数次
    public static void printOddTimesNum1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int ans = 0;
        for (int value : arr) {
            ans ^= value;
        }
        System.out.println(ans);

    }

    // arr中，有两种数，出现奇数次
    public static void printOddTimesNum2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        //1. 找出所有值异或的结果，假设最终值为ans = a ^ b ;
        // a,b 即为这两个出现奇数次的值
        int ans = 0;
        for (int value : arr) {
            ans ^= value;
        }

        //2. 找出ans中最右侧为1的值
        //eg. 00000000010000
        int rightOne = ans & (-ans);
        //3. 找出最右侧不为1数，即为a,b中其中一个值
        //eg. 0000000100
        //   ^0000001000
        //    0000000100
        int otherOne = 0;
        for (int value : arr) {
            if ((rightOne & value) != 0) {
                otherOne ^= value;
            }
        }
        int one = otherOne ^ ans;
        //4.异或求出另外一个值
        System.out.println(one);
        System.out.println(otherOne);


    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 4, 4, 4, 4, 3, 3, 8};
        printOddTimesNum2(arr);


    }


}
