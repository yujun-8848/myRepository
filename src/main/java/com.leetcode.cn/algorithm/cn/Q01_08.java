package com.leetcode.cn.algorithm.cn;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * 示例 1：
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2：
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 */
public class Q01_08 {

    /**
     * 使用数组将列与行存起来，然后置零.
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {

        int row = matrix.length;
        int column = matrix[0].length;
        int[] zeroRow = new int[row];
        int[] zeroCloumn = new int[column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(matrix[i][j] == 0){
                    zeroRow[i] = 1;
                    zeroCloumn[j] = 1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(zeroRow[i] == 1|| zeroCloumn[j] == 1){
                    matrix[i][j] =0;
                }
            }
        }
    }
}
