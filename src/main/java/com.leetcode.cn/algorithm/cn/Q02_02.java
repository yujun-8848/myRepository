package com.leetcode.cn.algorithm.cn;

/**
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例：
 * <p>
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 */
public class Q02_02 {

    public int kthToLast(ListNode head, int k) {

        ListNode temp = head;
        for (int i = 0; i < k; i++) {
            temp = temp.next;
        }
        while (temp != null) {
            temp = temp.next;
            head = head.next;
        }
        return head.val;
    }
}
