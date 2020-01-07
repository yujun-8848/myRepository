package com.leetcode.cn;

import java.util.*;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class permute {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        int len  = nums.length;
        boolean[] used = new boolean[len];
        if (len == 0) {
            return res;
        }
        generatePermute(nums,used,0,len,new Stack<>(),res);
        return res;
    }

    private void generatePermute(int[] nums, boolean[] visited, int curSize, int len, Stack<Integer> path, List<List<Integer>> res) {

        if (curSize == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                path.push(nums[i]);
                visited[i] = true;
                generatePermute(nums, visited, curSize + 1, len, path, res);
                path.pop();
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permute2(int[] nums){
        int len = nums.length;
        if(len == 0){
            return res;
        }
        Set<Integer> set = new HashSet<>();
        Stack<Integer> path = new Stack<>();
        generatePermute2(nums,set,0,len,path);
        return res;
    }

    private void generatePermute2(int[] nums, Set<Integer> used,int curSize,int len,Stack<Integer> path){

        if(curSize == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if(!used.contains(nums[i])){
                used.add(nums[i]);
                path.push(nums[i]);
                generatePermute2(nums,used,curSize +1,len,path);
                path.pop();
                used.remove(nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        permute permute = new permute();
        List<List<Integer>> permute1 = permute.permute2(nums);
        System.out.println(permute1);

    }

}
