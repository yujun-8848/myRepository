package com.leetcode.cn.com.sort.cn;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {

    public int[] Heap(int[] arr) {

        int temp;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {

            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }
        return arr;
    }


    /**
     * 将数组变为大顶堆
     *
     * @param arr    数组
     * @param i      非叶子节点索引
     * @param length 数组长度
     */
    public void adjustHeap(int[] arr, int i, int length) {

        int temp = arr[i];
        //k = 2 * i + 1为左节点
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            if (k < length - 1 && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;

    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] nums = {4,6,8,5,9};
        int[] heap = heapSort.Heap(nums);
        System.out.println(Arrays.toString(heap));
    }
}