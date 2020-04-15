package com.leetcode.cn.algorithm.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 */
public class Q02_01 {

    public ListNode removeDuplicateNodes(ListNode head) {

        ListNode cur = head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        Set<Integer> set = new HashSet<>();
        while (cur != null){
            if(!set.contains(cur.val)){
                set.add(cur.val);
                pre = cur;
            }else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
