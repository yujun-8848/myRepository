package com.leetcode.cn.com.recursive.cn;

/**
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 * 示例 1:
 * 输入:
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * 输出:
 * 2
 * 示例 2:
 * 输入:
 * 1
 * / \
 * 4   5
 * / \   \
 * 4   4   5
 * 输出:
 * 2
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 */
public class LongestUnivaluePath {

    private int maxL = 0;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public int longestUnivaluePath(TreeNode root) {

        if (root == null) {
            return 0;
        }
        getMax(root,root.val);
        return maxL;
    }

    private int getMax(TreeNode r, int val) {

        if (r == null) {
            return 0;
        }
        int left = getMax(r.left, r.val);
        int right = getMax(r.right, r.val);
        maxL = Math.max(maxL, left + right);
        if (r.val == val) {
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}
