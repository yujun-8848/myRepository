package com.leetcode.cn.algorithm.cn;

/**
 *
 */
public class Q11 {

    /**
     * 移动短板，因为移动短板可能会变大，移动长板必定会变小.
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {

        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i < j) {
            if(height[i] < height[j]){
                res = Math.max(res,(j - i) * height[i++]);
            }else {
                res = Math.max(res,(j - i) * height[j--]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
