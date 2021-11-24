package class11_test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yujun
 * @Description 二叉树可以通过先序、后序或者按层遍历的方式序列化和反序列化
 * @Date 2021/11/24
 */
public class Code02_SerializeAndReconstructTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Queue<String> preSerial(Node head) {
        Queue<String> queue = new LinkedList<>();
        pre(head, queue);
        return queue;
    }

    private static void pre(Node head, Queue<String> queue) {
        if (head == null) {
            queue.add(null);
        } else {
            queue.add(String.valueOf(head.value));
            pre(head.left, queue);
            pre(head.right, queue);
        }
    }

    public static Queue<String> inSerial(Node head) {
        Queue<String> queue = new LinkedList<>();
        in(head, queue);
        return queue;
    }

    private static void in(Node head, Queue<String> queue) {
        if (head == null) {
            queue.add(null);
        } else {
            pre(head.left, queue);
            queue.add(String.valueOf(head.value));
            pre(head.right, queue);
        }
    }

    public static Queue<String> posSerial(Node head) {
        Queue<String> queue = new LinkedList<>();
        pos(head, queue);
        return queue;
    }

    public static void pos(Node head, Queue<String> queue) {
        if (head == null) {
            queue.add(null);
        } else {
            pos(head.left, queue);
            pos(head.right, queue);
            queue.add(String.valueOf(head.value));
        }
    }

    //层次序列化
    public static Queue<String> levelSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.value));
            Queue<Node> queue = new LinkedList<>();
            queue.add(head);
            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                    ans.add(String.valueOf(cur.left.value));
                } else {
                    ans.add(null);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    ans.add(String.valueOf(cur.right.value));
                } else {
                    ans.add(null);
                }
            }
        }
        return ans;
    }

    //层次构建二叉树 反序列化
    public static Node buildByLevelQueue(Queue<String> levelList) {
        if (levelList == null || levelList.size() == 0) {
            return null;
        }
        Node head = generateNode(levelList.poll());
        if (head == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            cur.left = generateNode(levelList.poll());
            cur.right = generateNode(levelList.poll());
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return head;
    }

    public static Node generateNode(String val) {
        if (val == null) {
            return null;
        }
        return new Node(Integer.parseInt(val));
    }
}
