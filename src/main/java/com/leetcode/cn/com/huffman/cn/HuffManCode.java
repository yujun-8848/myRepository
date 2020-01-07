package com.leetcode.cn.com.huffman.cn;

import java.util.*;

/**
 * 赫夫曼编码
 */
public class HuffManCode {

    public static StringBuilder sb = new StringBuilder();
    public static Map<Byte, String> map = new HashMap<>();

    public static void main(String[] args) {
        HuffManCode code = new HuffManCode();
        String s = "i like like like java do you like a java";
        byte[] bytes = s.getBytes();
        List<Node> nodes = code.getNodes(bytes);
        Node root = code.createHuManTree(nodes);
        //code.preOrder(root);
        Map<Byte, String> getcodes = getcodes(root);
        System.out.println(getcodes);
        byte[] zip = code.zip(bytes, getcodes);
        System.out.println(Arrays.toString(zip));

    }

    public byte[] zip(byte[] bytes, Map<Byte, String> map) {
        StringBuilder builder = new StringBuilder();
        for (byte aByte : bytes) {
            builder.append(map.get(aByte));
        }
        int len = builder.length();
        if (len % 8 == 0) {
            len = len / 8;
        } else {
            len = len / 8 + 1;
        }
        byte[] codes = new byte[len];
        int index = 0;
        for (int i = 0; i < builder.length(); i += 8) {
            String by;
            if (i + 8 > builder.length()) {
                by = builder.substring(i);
            } else {
                by = builder.substring(i, i + 8);
            }
            codes[index] = (byte) Integer.parseInt(by, 2);
            index++;
        }
        return codes;
    }

    public static Map<Byte, String> getcodes(Node root) {
        if (root == null) {
            return null;
        }
        getCodes(root.left, "0", sb);
        getCodes(root.right, "1", sb);

        return map;
    }

    public static void getCodes(Node node, String code, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(code);
        if (node.data == null) {
            getCodes(node.left, "0", sb2);
            getCodes(node.right, "1", sb2);
        } else {
            map.put(node.data, sb2.toString());
        }
    }

    public Node createHuManTree(List<Node> list) {

        while (list.size() > 1) {

            Collections.sort(list);
            Node leftNode = list.get(0);
            Node rightNode = list.get(1);
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            list.remove(leftNode);
            list.remove(rightNode);
            list.add(parent);

        }
        return list.get(0);
    }

    public void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("空");
        }
    }


    public List<Node> getNodes(byte[] bytes) {
        List<Node> list = new ArrayList<>();

        Map<Byte, Integer> map = new HashMap<>();
        for (Byte aByte : bytes) {
            int value = map.getOrDefault(aByte, 0) + 1;
            map.put(aByte, value);
        }
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            list.add(new Node(entry.getKey(), entry.getValue()));
        }
        return list;
    }


    class Node implements Comparable<Node> {
        private Byte data;
        private int weight;
        private Node left;
        private Node right;

        public Node(Byte date, int weight) {
            this.data = date;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "date=" + data +
                    ", weight=" + weight +
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
            return this.weight - o.weight;
        }
    }
}
