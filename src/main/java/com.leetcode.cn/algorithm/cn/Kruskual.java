package com.leetcode.cn.algorithm.cn;

import java.util.Arrays;

/**
 * Created by Administrator on 2020/1/2.
 */
public class Kruskual {

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] data = {
                {0, 12, MAX, MAX, MAX, 16, 14},
                {12, 0, 10, MAX, MAX, 7, MAX},
                {MAX, 10, 0, 3, 5, 6, MAX},
                {MAX, MAX, 3, 0, 4, 4, MAX, MAX},
                {MAX, MAX, 5, 4, 0, 2, 2, 8},
                {16, 7, 6, MAX, 2, 0, 9},
                {14, MAX, MAX, MAX, 8, 9, 0}
        };
        Kruskual kruskual = new Kruskual(vertexs, data);
        System.out.println(kruskual.engeNum);
        for (int[] datum : kruskual.data) {
            System.out.println(Arrays.toString(datum));
        }
        Edata[] edges = kruskual.getEdges();
        System.out.println(Arrays.toString(edges));
        kruskual.kruskual();


    }

    public static final int MAX = Integer.MAX_VALUE;

    private int engeNum;//边的总数
    private char[] vertexs;//顶点值
    private int[][] data;//矩阵数值

    public Kruskual(char[] vertexs, int[][] data) {
        int len = vertexs.length;
        this.vertexs = new char[len];
        for (int i = 0; i < len; i++) {
            this.vertexs[i] = vertexs[i];
        }
        this.data = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                this.data[i][j] = data[i][j];
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (this.data[i][j] != MAX) {
                    engeNum++;
                }
            }
        }
    }

    /**
     * @param ch 顶点的值，比如'A','B'
     * @return 返回ch顶点对应的下标，如果找不到，返回-1
     */
    private int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    private int getEnds(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    private void sortEdges(Edata[] edata) {

        int temp;
        for (int i = 0; i < edata.length - 1; i++) {
            for (int j = 0; j < edata.length - 1 - i; j++) {
                if (edata[j].weight > edata[j + 1].weight) {
                    temp = edata[j + 1].weight;
                    edata[j + 1].weight = edata[j].weight;
                    edata[j].weight = temp;
                }
            }
        }
    }

    private Edata[] getEdges() {
        int index = 0;
        Edata[] edges = new Edata[engeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (data[i][j] != MAX) {
                    edges[index++] = new Edata(vertexs[i], vertexs[j], data[i][j]);
                }

            }
        }
        return edges;
    }

    private void kruskual(){
        int index = 0;
        int[] ends = new int[engeNum];
        Edata[] res =new Edata[engeNum];
        Edata[] edges = getEdges();
        sortEdges(edges);
        for (int i = 0; i < engeNum; i++) {
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);
            int m = getEnds(ends,p1);
            int n = getEnds(ends,p2);
            if(m != n){
                ends[m] = n;
                res[index++] = edges[i];
            }
        }
        for (int i = 0; i < engeNum; i++) {
            System.out.println(res[i]);
        }
    }
}

class Edata {

    public char start;
    public char end;
    public int weight;

    public Edata(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edata<" +
                "start=" + start +
                ", end=" + end +
                "> weight=" + weight;
    }


}
