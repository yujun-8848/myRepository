package com.leetcode.cn.com.sort.cn;

import java.util.Arrays;

/**
 * 选择排序
 */
public class Chose {

    public int[] choseSort(int[] nums){


        int minIndex = 0;
        for (int j = 0; j < nums.length ; j++) {
            int min = Integer.MAX_VALUE;
            for (int i = j; i < nums.length; i++) {

                if(min > nums[i]){
                    min = nums[i];
                    minIndex = i;
                }
            }
            if(minIndex != j){
                int temp = nums[j];
                nums[j] = nums[minIndex];
                nums[minIndex] = temp;
            }


        }
       return nums;
    }

    public static void main(String[] args) {
        Chose chose = new Chose();
        int[] nums = {3,1,5,89,4,0,-1,8};
        int[] res = chose.choseSort(nums);
        System.out.println(Arrays.toString(res));
    }
}
