package com.leetcode.cn;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class PermuteUnique {
    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        used = new boolean[len];
        Stack<Integer> path = new Stack<>();
        Arrays.sort(nums);
        generatePermuteUnique(nums, 0, path);
        return res;
    }

    //回溯+剪枝+贪心
    private void generatePermuteUnique(int[] nums, int curSize, Stack<Integer> path) {
        if (curSize == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i + 1]) {
                continue;
            }
            if (!used[i]) {
                path.push(nums[i]);
                used[i] = true;
                generatePermuteUnique(nums, curSize + 1, path);
                path.pop();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        PermuteUnique permuteUnique = new PermuteUnique();
        List<List<Integer>> lists = permuteUnique.permuteUnique(nums);
        System.out.println(lists);
    }
}
