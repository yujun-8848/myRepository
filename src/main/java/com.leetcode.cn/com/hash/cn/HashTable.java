package com.leetcode.cn.com.hash.cn;

/**
 * Created by Administrator on 2019/12/12.
 */
public class HashTable {

    public static void main(String[] args) {
        HashTab hashTab = new HashTab(5);
        hashTab.add(new Emp(1, "lisi"));
        hashTab.add(new Emp(2,"wangwu"));
        hashTab.add(new Emp(6,"zhangsan "));
        hashTab.find(2);
        hashTab.list();
    }

    private static class Emp {
        private int id;
        private String name;
        private Emp next;

        public Emp(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    private static class EmpLinkedList {
        private Emp head;

        private void add(Emp emp) {

            if (head == null) {
                head = emp;
                return;
            }
            Emp cur = head;
            while (true) {
                if (cur.next == null) {

                    break;
                }
                cur = cur.next;
            }
            cur.next = emp;

        }

        private void list() {
            if (head == null) {
                System.out.println("空");
                return;
            }

            Emp cur = head;
            while (true) {
                System.out.printf("%d,%s", cur.id, cur.name);

                if (cur.next == null) {
                    break;
                }
                cur = cur.next;
            }
            System.out.println();
        }

        private Emp findId(int id){
            if(head == null){
                System.out.println("kong");
                return null;
            }
            Emp cur = head;
            while (true){
                if(cur.id == id){
                    break;
                }
                if(cur.next == null){
                    cur = null;
                }

                cur = cur.next;
            }
            return cur;
        }
    }


    private static class HashTab {

        private EmpLinkedList[] empLinkedLists;
        private int size;

        public HashTab(int size) {
            this.size = size;
            empLinkedLists = new EmpLinkedList[size];

            for (int i = 0; i < size; i++) {
                empLinkedLists[i] = new EmpLinkedList();
            }
        }


        private void add(Emp emp) {
            int num = HashFun(emp.id);
            empLinkedLists[num].add(emp);
        }

        private void list() {
            for (int i = 0; i < size; i++) {
                empLinkedLists[i].list();
            }
        }
        private void find(int id){
            int num = HashFun(id);
            Emp emp = empLinkedLists[num].findId(id);
            if(emp != null){
                System.out.printf("%s",num);
            }
        }

        private int HashFun(int id) {
            return id % size;
        }
    }
}
