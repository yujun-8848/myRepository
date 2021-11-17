package class09_test;

import java.util.Stack;

/**
 * @author yujun
 * @Description 给定一个单链表的头节点head，请判断该链表是否为回文结构。
 * <p>
 * 链表问题就是coding问题，多练多练多练  QAQ
 * @Date 2021/11/16
 */
public class Code02_IsPalindromeList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    //使用stack的FILO，弹栈功能
    //需要耗费O(N)的空间复杂度，来判断是否是回文
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (stack.pop().value != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //使用快慢指针找到中点，然后使用stack的弹栈功能来判断是否是回文
    //需要耗费O(N / 2)的空间复杂度
    public static boolean isPalindrome2(Node head) {
        //快慢指针边界问题
        if(head == null || head.next == null){
            return true;
        }
        Node slow = head.next;
        Node fast = head;
        while (slow.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow找到下中点
        Stack<Node> stack = new Stack<>();
        while (slow != null){
            stack.push(slow);
            slow = slow.next;
        }
        while (!stack.isEmpty()){
            if(stack.pop().value != head.value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //自己手动拆解链表结构
    //空间复杂度O(1)
    public static boolean isPalindrome3() {


        return true;
    }

}
