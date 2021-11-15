package class09_test;

/**
 * @author yujun
 * @Description 使用快慢指针
 * 练习链表的基础coding
 * 多练，多练，多练 --QAQ--
 * @Date 2021/11/15
 */
public class Code01_LinkedListMid {

    private static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    //输入链表头节点，奇数长度返回中点，偶数长度返回上中点
    private static Node midOrUpMidNode(Node head) {
        //节点为一个的时候，返回其本身
        //节点为二个的时候，偶数，返回上中点，即也是其本身
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        //节点数大于等于3个
        //设置快慢指针
        //slow = head.next
        Node slow = head.next;
        //fast = head.next.next
        Node fast = head.next.next;
        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //输入链表头节点，奇数长度返回中点，偶数长度返回下中点
    private static Node midOrDownMidNode(Node head) {
        //节点为一个的时候，返回其本身
        //节点为二个的时候，偶数，返回上中点，即也是其本身
        if (head == null || head.next == null) {
            return head;
        }
        //设置快慢指针
        //slow = head.next
        Node slow = head.next;
        //fast = head.next
        Node fast = head.next;
        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //输入链表头节点，奇数长度返回中点前一个，偶数长度返回上中点前一个
    private static Node midOrUpMidPreNode(Node head) {
        //节点为一个的时候，返回其本身
        //节点为二个的时候，偶数，返回上中点，即也是其本身
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head.next.next;
        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //输入链表头节点，奇数长度返回中点前一个，偶数长度返回下中点前一个
    private static Node midOrDownMidPreNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        if (head.next.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
