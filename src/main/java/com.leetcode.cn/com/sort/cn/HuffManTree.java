package com.leetcode.cn.com.sort.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 赫夫曼树
 */
public class HuffManTree {

    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        HuffManTree huffManTree = new HuffManTree();
        Node root = huffManTree.createHuffManTree(arr);
        huffManTree.preOrder(root);
    }

    public void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("空树");
        }
    }

    public Node createHuffManTree(int[] arr) {

        List<Node> list = new ArrayList<>();
        for (int i : arr) {
            list.add(new Node(i));
        }

        while (list.size() > 1) {
            Collections.sort(list);
           //System.out.println(list);
            Node leftNode = list.get(0);
            Node rightNode = list.get(1);
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            list.remove(leftNode);
            list.remove(rightNode);
            list.add(parent);
        }
        return list.get(0);

    }

    class Node implements Comparable<Node> {
       private int value;
       private Node left;
       private Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

        private void preOrder() {
            System.out.println(this);
            if (this.left != null) {
                this.left.preOrder();
            }
            if (this.right != null) {
                this.right.preOrder();
            }
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
