package class08_test;

/**
 * @author yujun
 * @Description 前缀树的基本实现
 * @Date 2021/11/14
 */
public class Code01_TrieTree {

    public static class Node {
        public int pass;
        public int end;
        public Node[] next;

        public Node() {
            this.pass = 0;
            this.end = 0;
            //初始化给出a-z共26种情况的字母
            this.next = new Node[26];
        }
    }


    public static class TrieTree {
        private final Node root;

        public TrieTree() {
            root = new Node();
        }

        //添加某个字符串，可以重复添加，每次算1个
        public void insert(String str) {
            if (str == null) {
                return;
            }
            char[] chars = str.toCharArray();
            //指针指向同一内存地址
            Node node = root;
            node.pass++;
            int path;
            for (char ch : chars) {
                path = ch - 'a';
                //重复可多次计数，通过pass来标识重复个数
                //如果不为null，则创建下一个节点
                if (node.next[path] == null) {
                    node.next[path] = new Node();
                }
                node = node.next[path];
                node.pass++;
            }
            node.end++;
        }

        //查询某个字符串在结构中还有几个
        public int search(String str) {
            if (str == null) {
                return 0;
            }
            Node node = root;
            char[] chars = str.toCharArray();
            int path;
            for (char aChar : chars) {
                path = aChar - 'a';
                if (node.next[path] == null) {
                    return 0;
                }
                node = node.next[path];
            }
            return node.end;
        }

        // 删掉某个字符串，可以重复删除，每次算1个
        public void delete(String str) {
            if (str == null) {
                return;
            }
            if (search(str) != 0) {
                Node node = root;
                node.pass--;
                char[] chars = str.toCharArray();
                int path;
                for (char aChar : chars) {
                    path = aChar - 'a';
                    //防止出现内存泄漏，帮助GC
                    if (--node.next[path].pass == 0) {
                        node.next[path] = null;
                        return;
                    }
                    node = node.next[path];
                }
                node.end--;
            }
        }

        //查询有多少个字符串，是以str做前缀的
        public int prefixNumber(String str) {
            if (str == null) {
                return 0;
            }
            Node node = root;
            int path;
            char[] chars = str.toCharArray();
            for (char aChar : chars) {
                path = aChar - 'a';
                if (node.next[path] == null) {
                    return 0;
                }
                node = node.next[path];
            }
            return node.pass;
        }
    }

    public static void main(String[] args) {
//        TrieTree tree = new TrieTree();
//        tree.insert("abc");
//        System.out.println(tree.search("abc"));
//        System.out.println(tree.prefixNumber("ab"));
//        tree.delete("abc");
//        System.out.println(tree.search("abc"));
//        System.out.println(tree.prefixNumber("ab"));
        int a = 5;
        while (a > 0){
            if(--a == 1){
                System.out.println(a);
            }else {
                System.out.println(a + "---");
            }
        }
    }


}
