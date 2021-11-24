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

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
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

    //如果两个链表都无环，则通过判断两个链表遍历到最后一个节点是否相等
    //如果不相等，则不相交
    //否则必定相交
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int sum = 0;
        Node cur1 = head1;
        Node cur2 = head2;
        while (cur1.next != null) {
            sum++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            sum--;
            cur2 = cur2.next;
        }
        //遍历到结尾都不相等，则表示不相交
        if (cur1 != cur2) {
            return null;
        }
        //找出长链表
        cur1 = sum > 0 ? head1 : head2;
        //设置短链表
        cur2 = cur1 == head1 ? head2 : head1;
        sum = Math.abs(sum);
        while (sum != 0) {
            sum--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    //两个链表都有环
    //loop1为head1的第一个入环节点
    //loop2为head2的第第一入环节点
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }

    }
}
