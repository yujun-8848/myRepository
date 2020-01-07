package com.leetcode.cn.algorithm.cn;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Random;

/**
 * Created by Administrator on 2020/1/6.
 */
public class BitMap {

    public static final int min = 1000;

    public static void main(String[] args) {
//        BitMap bitMap = new BitMap();
//        bitMap.findDup(800);
        long beforeMemory = Runtime.getRuntime().totalMemory();
        long start1 = System.currentTimeMillis();
        BitSet set = new BitSet(2000000000);
        for (int i = 0; i < 2000000000; i++) {
   /*假设898989这个数不在20亿个数里面*/
            if (i != 898989) {
                set.set(i, true);
            }
        }
  /*创建20亿个数后所占内存*/
        long afterMemory = Runtime.getRuntime().totalMemory();
        long end1 = System.currentTimeMillis();
        System.out.println("总共内存使用:" + (afterMemory - beforeMemory) / 1024 / 1024 + "MB");
        System.out.println("存入内存耗时:" + (end1 - start1) + "毫秒");
        long start2 = System.currentTimeMillis();
        boolean isExit1 = set.get(898989);
        boolean isExit2 = set.get(900000);

        long end2 = System.currentTimeMillis();
  /*输出在20亿个数中判断898989是否包含在里面*/
        System.out.println(isExit1);
        System.out.println("20个亿中" + (isExit1 ? "包含" : "不包含") + 898989);
        System.out.println("20个亿中" + (isExit2 ? "包含" : "不包含") + 900000);
        System.out.println("查询用时:" + (end2 - start2) + "毫秒");

    }

    public void findDup(int size) {
        BitSet bitSet = new BitSet();
        int[] array = getArray(size);
        for (int i = 0; i < array.length; i++) {
            bitSet.set(array[i] - min);
        }
        int count = 0;
        for (int i = 0; i < bitSet.size(); i++) {
            if (bitSet.get(i)) {
                System.out.println(i + min + " ");
                count++;
            }
        }
        System.out.println(count);

    }

    public int[] getArray(int size) {

        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt() + min;
            if (array[i] < 0) {
                array[i] = -array[i];
            }
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
}
