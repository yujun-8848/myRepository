package class09_test;

/**
 * @author yujun
 * @Description 给定两个可能有环也可能无环的单链表，头节点head1和head2。
 * 请实现一个函数，如果两个链表相交，请返回相交的 第一个节点。如果不相交，返回null
 * 【要求】
 * 如果两个链表长度之和为N，时间复杂度请达到O(N)，额外空间复杂度 请达到O(1)。
 * @Date 2021/11/18
 */
public class Code05_FindFirstIntersectNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getIntersectNode(Node head) {

        return null;
    }

    //给定一个链表的头节点，返回第一个入环节点
    //如果没有环，则返回null
    public static Node getLoopNode(Node head) {
        //一个节点或者两个节点无法成环
        //返回Null
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        //使用快慢指针
        Node slow = head.next;
        Node fast = head.next.next;
        //直到快慢指针相遇
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                //无环，直接退出
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static Node noLoop(Node head1, Node head2) {

        return null;
    }

    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {


        return null;
    }
}
