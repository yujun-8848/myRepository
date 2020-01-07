package com.leetcode.cn.algorithm.cn;

import java.util.Arrays;

/**
 * 普利姆算法
 */
public class MST {
    public static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {

        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        int[][] weight = new int[][]{
                {MAX, 5, 7, MAX, MAX, MAX, 2},
                {5, MAX, MAX, 9, MAX, MAX, 3},
                {7, MAX, MAX, MAX, 8, MAX, MAX},
                {MAX, 9, MAX, MAX, MAX, 4, MAX},
                {MAX, MAX, 8, MAX, MAX, 5, 4},
                {MAX, MAX, MAX, 4, 5, MAX, 6},
                {2, 3, MAX, MAX, 4, 6, MAX}
        };
        MGraph graph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, verxs, data, weight);
        // minTree.showGraph(graph);
        minTree.prim(graph, 0);

    }
}

class MinTree {
    public static final int MAX = Integer.MAX_VALUE;

    public void prim(MGraph graph, int v) {
        int[] visited = new int[graph.verxs];
        visited[v] = 1;

        int minWeight = MAX;
        int h1 = -1;
        int h2 = -1;
        for (int k = 1; k < graph.verxs; k++) {
            for (int i = 0; i < graph.verxs; i++) {
                for (int j = 0; j < graph.verxs; j++) {

                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.println(graph.data[h1] + "," + graph.data[h2] + " " + minWeight);
            visited[h2] = 1;
            minWeight = MAX;
        }


    }

    public void createGraph(MGraph graph, int verxs, char[] data, int[][] weight) {

        for (int i = 0; i < verxs; i++) {
            graph.data[i] = data[i];
            for (int j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }


}

class MGraph {

    int verxs;//节点数
    char[] data;//节点数据
    int[][] weight;//边的数据

    MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
