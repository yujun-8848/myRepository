package class09_test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yujun
 * @Description 一种特殊的单链表节点类描述如下
 * class Node {
 * int value;
 * Node next;
 * Node rand;
 * Node(int val) { value = val; }
 * }
 * rand指针是单链表节点结构中新增的指针，rand可能指向链表中的任意一个节点，也可能指向null。
 * 给定一个由Node节点类型组成的无环单链表的头节点 head，
 * 请实现一个函数完成这个链表的复制，并返回复制的新链表的头节点。
 * 【要求】
 * 时间复杂度O(N)，额外空间复杂度O(1)
 * @Date 2021/11/18
 */
public class Code04_CopyListWithRandom {

    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int value) {
            this.value = value;
        }
    }

    //通过容器的方式来重新连接节点
    //需要承担O(N)的空间复杂度
    public static Node copyRandomList1(Node head) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        //使用map容器来存储新复制的节点
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            //key 老节点
            //value 新生成的节点
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    //原先结构：1 -> 2 -> 3 -> null
    //复制过后的结构：1 -> 1` -> 2 -> 2` -> 3 -> 3` -> null
    public static Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        //每个节点后面复制一个新的节点1`,2`,3`
        Node cur = head;
        Node next;
        //1 -> 1` -> 2 -> 2` -> 3 -> 3` -> null
        //不包含rand指针，仅包含next指针
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        //重新设置旧链表头
        cur = head;
        Node copy;
        //设置rand指针
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            copy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        //设置新链表头
        Node res = head.next;
        //新旧链表结构拆开
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            cur.next = next;
            copy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }
}
