package class03_test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yujun
 * @Description 链表相关的问题几乎都是coding问题
 * 好好练，基本功 OVO
 * 利用编程技巧 变量 pre和 next 来推进
 * @Date 2021/11/2
 */
public class Code01_ReverseList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private static class DoubleNode {
        private int value;
        private DoubleNode last;
        private DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    //翻转双向链表
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        if (head == null) {
            return null;
        }
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;

    }

    //翻转链表
    //a -> b -> c -> null
    //c -> b -> a -> null
    public static Node reverseLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        //coding技巧 OVO
        //记录前一个位置pre
        //记录后一个位置next
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //手动翻转链表用于测试
    public static Node tesTreverseLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        List<Node> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head);
            head = head.next;
        }
        ans.get(0).next = null;
        for (int i = 1; i < ans.size(); i++) {
            ans.get(i).next = ans.get(i - 1);
        }
        return ans.get(ans.size() - 1);

    }

    public static Node generateRandomLinkedList(int len, int value) {
        int size = (int) ((len + 1) * Math.random());
        if (size == 0) {
            return null;
        }
        Node head = new Node((int) ((value + 1) * Math.random()));
        Node pre = head;
        while (size != 0) {
            Node next = new Node((int) ((value + 1) * Math.random()));
            pre.next = next;
            pre = next;
            size--;
        }
        return head;

    }

    // for test
    public static List<Integer> getLinkedListOriginOrder(Node head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }

    public static boolean checkLinkedListReverse(List<Integer> ans, Node node) {
        for (int i = ans.size() - 1; i > 0; i--) {
            if (ans.get(i) != node.value) {
                System.out.println(ans.get(i));
                System.out.println(node.value);
                return false;
            }
            node = node.next;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("开始测试");
        int testTime = 100;
        int len = 10;
        int value = 10;
        for (int i = 0; i < testTime; i++) {
            Node node = generateRandomLinkedList(len, value);
            Node node1 = reverseLinkedList(node);
            List<Integer> list = getLinkedListOriginOrder(node1);
            if (!checkLinkedListReverse(list, node)) {
                System.out.println("测试失败");
                break;
            }
        }


        System.out.println("结束测试");
    }


}
