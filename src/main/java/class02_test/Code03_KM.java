package class02_test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author yujun
 * @Description 一个数组中有一种数出现K次，其他数都出现了M次
 * M > 1,  K < M
 * 找到，出现了K次的数，
 * 要求，额外空间复杂度O(1)，时间复杂度O(N)
 * @Date 2021/10/29
 */
public class Code03_KM {

    public static int KM_test(int[] arr, int k, int m) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer i : map.keySet()) {
            if (map.get(i) == k) {
                return i;
            }
        }
        return -1;

    }


    private static final Map<Integer, Integer> map = new HashMap<>();

    public static int KM(int[] arr, int k, int m) {
        // int 4bytes 32bit
        //对每个位置进行计数
        int[] size = new int[32];
        initMap(size);
        for (int num : arr) {
            while (num != 0) {
                // 取出每一位的最右侧1  00001000
                int rightOne = num & (-num);
                //对每一位进行累加计数
                size[map.get(rightOne)]++;
                num ^= rightOne;
            }
        }
        //size已经准备好了
        //由于数组中有很多数都是m次，则它们在size中的值肯定也是M
        int ans = 0;
        for (int i = 0; i < size.length; i++) {
            if (size[i] % m != 0) {
                if (size[i] % m == k) {
                    // 0000000
                    // 0000100
                    // 0000100
                    //将值设入到ans中
                    ans |= 1 << i;
                } else {
                    return -1;
                }

            }
        }
        if(ans == 0){
            int count = 0;
            for (int num : arr) {
                if(num == 0){
                    count++;
                }
            }
            if(count != k){
                return -1;
            }
        }
        return ans;
    }


    public static void initMap(int[] arr) {
        int value = 1;
        for (int i = 0; i < arr.length; i++) {
            map.put(value, i);
            value <<= 1;
        }
    }

    public static int[] randomArray(int maxKinds, int range, int k, int m) {
        int ktimeNum = randomNumber(range);
        // 真命天子出现的次数
        int times = Math.random() < 0.5 ? k : ((int) (Math.random() * (m - 1)) + 1);
        // 2
        int numKinds = (int) (Math.random() * maxKinds) + 2;
        // k * 1 + (numKinds - 1) * m
        int[] arr = new int[times + (numKinds - 1) * m];
        int index = 0;
        for (; index < times; index++) {
            arr[index] = ktimeNum;
        }
        numKinds--;
        HashSet<Integer> set = new HashSet<>();
        set.add(ktimeNum);
        while (numKinds != 0) {
            int curNum = 0;
            do {
                curNum = randomNumber(range);
            } while (set.contains(curNum));
            set.add(curNum);
            numKinds--;
            for (int i = 0; i < m; i++) {
                arr[index++] = curNum;
            }
        }
        // arr 填好了
        for (int i = 0; i < arr.length; i++) {
            // i 位置的数，我想随机和j位置的数做交换
            int j = (int) (Math.random() * arr.length);// 0 ~ N-1
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return arr;
    }

    // [-range, +range]
    public static int randomNumber(int range) {
        return ((int) (Math.random() * range) + 1) - ((int) (Math.random() * range) + 1);
    }

    public static void main(String[] args) {
        int kinds = 5;
        int range = 30;
        int testTime = 100000;
        int max = 9;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int a = (int) (Math.random() * max) + 1; // a 1 ~ 9
            int b = (int) (Math.random() * max) + 1; // b 1 ~ 9
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            // k < m
            if (k == m) {
                m++;
            }
            int[] arr = randomArray(kinds, range, k, m);
            int ans1 = KM_test(arr, k, m);
            int ans2 = KM(arr, k, m);
            if (ans1 != ans2) {
                System.out.println(Arrays.toString(arr));
                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println("出错了！");
            }
        }
        System.out.println("测试结束");

//        int[] arr = {-23, 0, -23, 0, -23, 0, 0, -23, 0, -23, -23, -23, -23, -23};
//        int k =5;
//        int m = 9;
//        System.out.println(KM(arr, k, m));

    }

}
