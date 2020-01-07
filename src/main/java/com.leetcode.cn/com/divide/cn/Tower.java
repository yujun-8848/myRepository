package com.leetcode.cn.com.divide.cn;

/**
 * Created by Administrator on 2019/12/28.
 */
public class Tower {


    /**
     * 使用分治的思想来解决汉罗塔问题
     * 简单的可以将汉罗塔分为2部分，上面所有以及最下面一个，
     * 例如; 2 个
     * 1 -> B
     * 2 -> C
     * 1 -> C
     *
     * @param nums 需要移动的汉罗塔数量
     * @param a    汉罗塔A
     * @param b    汉罗塔B
     * @param c    汉罗塔C
     */
    public void hanoiTower(int nums, char a, char b, char c) {
        if (nums == 1) {
            System.out.println("从1盘" + a + "->" + c);
        } else {
            hanoiTower(nums - 1, a, c, b);
            System.out.println("从"+ nums +"盘"+ a + "->" + c);
            hanoiTower(nums - 1, b, a, c);
        }
    }

    public static void main(String[] args) {
        new Tower().hanoiTower(5,'A','B','C');
    }

}
