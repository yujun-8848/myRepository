package class09_test;

/**
 * @author yujun
 * @Description 将单向链表按某值划分成左边小、中间相等、右边大的形式
 * <p>
 * 1）把链表放入数组里，在数组上做partition（笔试用）
 * <p>
 * 2）分成小、中、大三部分，再把各个部分之间串起来（面试用）
 * @Date 2021/11/16
 */
public class Code03_SmallerEqualBigger {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    //通过数组来区分开小，中，大三个部分
    //手动将他们串联起来
    public static Node listPartition1(Node head, int pivot) {
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = head;
        int sum = 0;
        while (cur != null) {
            sum++;
            cur = cur.next;
        }
        //重新指向头部节点
        cur = head;
        Node[] res = new Node[sum];
        for (int i = 0; i < res.length; i++) {
            res[i] = cur;
            cur = cur.next;
        }
        addPartition(res, pivot);
        for (int i = 1; i < res.length; i++) {
            res[i - 1].next = res[i];
        }
        res[res.length - 1].next = null;
        return res[0];
    }

    //手动拆解链表结构
    //分为小于区域头，小于区域尾
    //等于区域头，等于区域尾
    //大于区域头，大于区域尾
    public static Node listPartition2(Node head, int pivot) {
        if (head == null || head.next == null) {
            return head;
        }
        Node SH = null;
        Node ST = null;
        Node EH = null;
        Node ET = null;
        Node BH = null;
        Node BT = null;
        //记录下一步head环境
        Node next;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (SH == null) {
                    SH = head;
                    ST = head;
                } else {
                    ST.next = head;
                    ST = head;
                }
            } else if (head.value == pivot) {
                if (EH == null) {
                    EH = head;
                    ET = head;
                } else {
                    ET.next = head;
                    ET = head;
                }
            } else {
                if (BH == null) {
                    BH = head;
                    BT = head;
                } else {
                    BT.next = head;
                    BT = head;
                }
            }
            head = next;
        }

        if (ST != null) {
            ST.next = EH;
            //无ET
            ET = ET == null ? ST : ET;
        }
        if (ET != null) {
            ET.next = BH;
        }
        return SH != null ? SH : (EH != null ? EH : BH);

    }

    //分区
    //小，中，大
    //类似于快排中的分区：即荷兰国旗问题
    public static void addPartition(Node[] res, int pivot) {
        int L = -1;
        int R = res.length;
        int index = 0;
        while (index < R) {
            if (res[index].value == pivot) {
                index++;
            } else if (res[index].value < pivot) {
                swap(res, ++L, index++);
            } else {
                swap(res, --R, index);
            }
        }
    }

    public static void swap(Node[] res, int i, int j) {
        Node temp = res[i];
        res[i] = res[j];
        res[j] = temp;

    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
//        head1 = listPartition1(head1, 5);
//        printLinkedList(head1);
        Node node = listPartition2(head1, 5);
        printLinkedList(node);
    }
}
