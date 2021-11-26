package class12_test;

import java.util.LinkedList;

/**
 * @author yujun
 * @Description 使用二叉树的递归套路来分析:
 * 本质是利用二叉树的后序遍历，通过左树信息和右树信息推出节点信息，依次递归
 * 判断一个树是否是完全二叉树
 * 以x作为二叉树的头节点
 * 1.左树:是完全二叉树，leftH = rightH + 1
 * 右树：是满二叉树
 * 2.左树： 满二叉树
 * 右树： 满二叉树  leftH = rightH + 1
 * 3.左树： 满二叉树
 * 右树： 完全二叉树，rightH = leftH
 * @Date 2021/11/26
 */
public class Code01_IsCBT {
    public static boolean isCBT1(Node head) {
        if (head == null) {
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        // 是否遇到过左右两个孩子不双全的节点
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if (
                // 如果遇到了不双全的节点之后，又发现当前节点不是叶节点
                    (leaf && (l != null || r != null))
                            ||
                            (l == null && r != null)

            ) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Info {
        public boolean isFull;
        public boolean isCBT;
        public int height;

        public Info(boolean isFull, boolean isCBT, int height) {
            this.isFull = isFull;
            this.isCBT = isCBT;
            this.height = height;
        }
    }

    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        return process(head).isCBT;
    }

    public static Info process(Node head) {
        //base case
        if (head == null) {
            //如果head为空，即是一颗空树
            //认为它是完全二叉树，也是满二叉树，hegiht = 0
            return new Info(true, true, 0);
        }
        //递归找出左右子树的信息
        Info left = process(head.left);
        Info right = process(head.right);
        //当前head所构建的树的高度
        int height = Math.max(left.height, right.height) + 1;
        //当前head所构建的树是否是满二叉树
        boolean isFull = left.isFull && right.isFull && left.height == right.height;
        //当前head所构建的树是否是完全二叉树
        boolean isCBT = false;
        if (isFull) {
            isCBT = true;
        } else {
            if (left.isCBT && right.isFull && left.height == right.height + 1) {
                isCBT = true;
            }
            if (left.isFull && right.isCBT && left.height == right.height) {
                isCBT = true;
            }
            if (left.isFull && right.isFull && left.height == right.height + 1) {
                isCBT = true;
            }
        }
        return new Info(isFull, isCBT, height);
    }

    // for test
    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (isCBT1(head) != isCBT(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }
}
