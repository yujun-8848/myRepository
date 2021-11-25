package class11_test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yujun
 * @Description 求二叉树最宽的层有多少个节点
 * @Date 2021/11/25
 */
public class Code05_TreeMaxWidth {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int maxWidthNoMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        //记录最大值
        int max = 0;
        //记录当前层节点个数
        int curLevelNodes = 0;
        //记录当前值
        Node curEnd = head;
        //记录每一层的最右值
        Node nextEnd = null;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            curLevelNodes++;
            //表示已经达到每一层的最后一个节点
            //即将进入下一层
            if (cur == curEnd) {
                max = Math.max(max, curLevelNodes);
                curLevelNodes = 0;
                curEnd = nextEnd;
            }
        }
        return max;
    }
}
