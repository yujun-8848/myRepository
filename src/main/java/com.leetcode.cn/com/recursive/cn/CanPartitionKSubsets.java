package com.leetcode.cn.com.recursive.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * 示例 1：
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 */
public class CanPartitionKSubsets {
    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] used;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);
        int row = nums.length - 1;
        while (row > 0 && nums[row] == target) {
            k--;
            row--;
        }

        return search(new int[k], row, nums, target);
    }

    public boolean search(int[] groups, int row, int[] nums, int target) {

        if (row < 0) {
            return true;
        }
        int v = nums[row--];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v;
                if (search(groups, row, nums, target)) {
                    return true;
                }
                groups[i] -= v;
            }
            if (groups[i] == 0) {
                break;
            }
        }
        return false;
    }

    public List<List<Integer>> canPartitionKSubsets2(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return null;
        }
        int target = sum / k;
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        if (max > target) {
            return null;
        }
        Stack<Integer> ans = new Stack<>();
        used = new boolean[nums.length];
        search2(nums,k,target,0,0,ans);
        return res;
    }

    public void search2(int[] nums, int k, int target, int curSize, int start, Stack<Integer> ans) {
        if (k == 0) {
            return;
        }
        if (curSize == target) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (!used[i] && curSize + nums[i] <= target) {
                used[i] = true;
                ans.push(nums[i]);
                search2(nums, k, target, curSize + nums[i], i + 1, ans);
                ans.pop();
                used[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        CanPartitionKSubsets canPartitionKSubsets = new CanPartitionKSubsets();
        System.out.println(canPartitionKSubsets.canPartitionKSubsets2(nums, 4));
    }
}
