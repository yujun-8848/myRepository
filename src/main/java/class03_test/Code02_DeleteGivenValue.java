package class03_test;

/**
 * @author yujun
 * @Description 把给定值都删除
 * 善用编程技巧 pre cur
 * pre 表示cur的前一个值
 * cur 表示当前值
 * 如果cur == num 则通过 pre.next = cur.next 来删除给定值
 * @Date 2021/11/2
 */
public class Code02_DeleteGivenValue {

    private static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    // head = removeValue(head, 2);
    public static Node removeValue(Node head, int num) {
        if(head == null){
            return null;
        }
        //之前的数可能一直==num
        //得出第一个head 不为num
        while (head.value == num){
            head = head.next;
        }
        //coding 技巧
        //必须熟练掌握才行 OVO!
        Node pre = head;
        Node cur = head;
        while (cur != null){
            if(cur.value == num){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;



    }
}
