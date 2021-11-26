package class12_test;

import java.util.ArrayList;

/**
 * @author yujun
 * @Description 二叉搜索树 binary search tree
 * 二叉搜索树的中序遍历即是个由低到高的有序列
 * 左树的所有节点值均小于根节点值
 * 右树的所有节点值均大于根节点值
 * 通过二叉树的递归套路分析可能性
 * 根节点x
 * 1. 左树 节点最大值max < x.value
 * 左树是否是二叉搜索树
 * 右树 节点最小值min > x.value
 * 右树是否是二叉搜索树
 * @Date 2021/11/26
 */
public class Code02_IsBST {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Info {
        public boolean isBST;
        public int max;
        public int min;

        public Info(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

    public static boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        return process(head).isBST;
    }

    public static Info process(Node x) {
        //base case
        if (x == null) {
            //如果该子树为空，不知道改设置为何值时，直接判定为null
            return null;
        }
        //搜集左子树信息
        Info left = process(x.left);
        //搜集右子树信息
        Info right = process(x.right);

        //通过左右子树的信息得出x树的信息
        int max = x.value;
        if (left != null) {
            max = Math.max(max, left.max);
        }
        if (right != null) {
            max = Math.max(max, right.max);
        }
        int min = x.value;
        if (left != null) {
            min = Math.min(min, left.min);
        }
        if (right != null) {
            min = Math.min(min, right.min);
        }
        boolean isBST = true;
        if (left != null && !left.isBST) {
            isBST = false;
        }
        if (right != null && !right.isBST) {
            isBST = false;
        }
        if (left != null && left.max >= x.value) {
            isBST = false;
        }
        if (right != null && right.min <= x.value) {
            isBST = false;
        }
        return new Info(isBST, max, min);

    }

    public static boolean isBST1(Node head) {
        if (head == null) {
            return true;
        }
        ArrayList<Node> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).value <= arr.get(i - 1).value) {
                return false;
            }
        }
        return true;
    }

    public static void in(Node head, ArrayList<Node> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
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
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (isBST(head) != isBST1(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

}
