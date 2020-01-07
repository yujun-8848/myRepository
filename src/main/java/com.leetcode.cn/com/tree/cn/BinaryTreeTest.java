package com.leetcode.cn.com.tree.cn;

/**
 * Created by Administrator on 2019/12/19.
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        int[] nums = {7, 3, 10, 12, 5, 1, 9};
        for (int i = 0; i < nums.length; i++) {
            binaryTree.add(new Node(nums[i]));
        }
        binaryTree.inFixOrder();
        System.out.println(binaryTree.getRoot().height());

    }

    public static class BinaryTree {
        private Node root;

        public Node getRoot(){
            return root;
        }

        public void add(Node node) {
            if (root == null) {
                root = node;
            } else {
                root.add(node);
            }
        }

        public void inFixOrder() {

            if (root == null) {
                System.out.println("空树");
            } else {
                root.inFixOrder();
            }
        }
    }

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public int leftHeight(){
            if(left == null){
                return 0;
            }
            return  left.height();
        }
        public int rightHeight(){
            if(right == null){
                return 0;
            }
            return right.height();
        }

        public int height() {
            return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
        }

        public Node search(int value) {

            if (value == this.value) {
                return this;
            } else if (value < this.value) {
                if (this.left == null) {
                    return null;
                }
                return this.left.search(value);
            } else {
                if (this.right == null) {
                    return null;
                }
                return this.right.search(value);
            }
        }

        public Node searchParent(int value) {

            if (this.left != null && this.left.value == value || this.right != null && this.right.value == value) {
                return this;
            } else if (value < this.value && this.left != null) {
                return this.left.search(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.search(value);
            } else {
                return null;
            }
        }

        public void add(Node node) {

            if (node == null) {
                return;
            }
            if (node.value < this.value) {
                if (this.left == null) {
                    this.left = node;
                } else {
                    this.left.add(node);
                }
            } else {
                if (this.right == null) {
                    this.right = node;
                } else {
                    this.right.add(node);
                }
            }
        }

        //中序遍历
        public void inFixOrder() {

            if (this.left != null) {
                this.left.inFixOrder();
            }
            System.out.println(this);
            if (this.right != null) {
                this.right.inFixOrder();
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
