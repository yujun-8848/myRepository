package class12_test;

/**
 * @author yujun
 * @Description 平衡二叉树
 * 它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树
 * 根据递归套路分析可能性：
 * 以x为头节点
 * 1. 左树  height
 * 右树 height
 * isBST
 * @Date 2021/11/26
 */
public class Code03_IsBalanced {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    public static boolean isBalanced1(Node head) {
        boolean[] ans = new boolean[1];
        ans[0] = true;
        process1(head, ans);
        return ans[0];
    }

    public static int process1(Node head, boolean[] ans) {
        if (!ans[0] || head == null) {
            return -1;
        }
        int leftHeight = process1(head.left, ans);
        int rightHeight = process1(head.right, ans);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            ans[0] = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static class Info {
        public int height;
        public boolean isBST;

        public Info(int height, boolean isBST) {
            this.height = height;
            this.isBST = isBST;
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
            return new Info(0, true);
        }
        Info left = process(x.left);
        Info right = process(x.right);

        int height = Math.max(left.height, right.height) + 1;
        int res = left.height - right.height;
        boolean isBST = true;
        if (!left.isBST) {
            isBST = false;
        }
        if (!right.isBST) {
            isBST = false;
        }
        if (Math.abs(res) > 1) {
            isBST = false;
        }
        return new Info(height, isBST);

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
            if (isBalanced1(head) != isBST(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

}
