package class11_test;

/**
 * @author yujun
 * @Description 二叉树结构如下定义：
 * Class Node {
 * V value;
 * Node left;
 * Node right;
 * Node parent;
 * }
 * 给你二叉树中的某个节点，返回该节点的后继节点
 * @Date 2021/11/25
 */
public class Code06_SuccessorNode {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getSuccessorNode(Node  node){
        if(node == null){
            return null;
        }
        if(node.right != null){
            //如果右树!=null 则右树上的最左孩子是后继节点
            return getMostLeft(node.right);
        }else {
            Node parent = node.parent;
            while (parent != null && parent.right == node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private static Node getMostLeft(Node head) {
        if(head == null){
            return null;
        }
        while (head.left != null){
            head = head.left;
        }
        return head;
    }
}
