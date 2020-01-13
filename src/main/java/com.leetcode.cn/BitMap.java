package com.leetcode.cn;

/**
 * Created by Administrator on 2019/11/2.
 */
public class BitMap {

    private static int[] bitmap;

    public static void main(String[] args) {


        long beforeMemory = Runtime.getRuntime().totalMemory();
        long start1 = System.currentTimeMillis();
        bitmap = new int[200000000];
        for (int i = 0; i < 200000000; i++) {
            if (i == 135446435) {
                continue;
            }
            insertDate(i);
        }
        boolean numberExist = isNumberExist(454442);
        System.out.println(numberExist);
        long afterMemory = Runtime.getRuntime().totalMemory();
        long end1 = System.currentTimeMillis();
        System.out.println("总共内存使用:" + (afterMemory - beforeMemory) / 1024 / 1024 + "MB");
        System.out.println("存入内存耗时:" + (end1 - start1) + "毫秒");

    }


    public static void insertDate(int number) {
        int bit = number >> 5;
        int index = number & ((1 << 5) - 1);
        bitmap[bit] = bitmap[bit] | (1 << index);
    }

    public static boolean isNumberExist(int number) {
        int bit = number >> 5;
        int index = number & ((1 << 5) - 1);
        return ((1 << index) & bitmap[bit]) != 0;
    }

}
