package com.leetcode.cn.algorithm.cn;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * 马踏棋盘算法
 */
public class Horse {

    public static int X = 0;
    public static int Y = 0;
    public static boolean visited[];
    public static boolean finished;


    public static void main(String[] args) {
        X = 8;
        Y = 8;
        int[][] chessBorad = new int[X][Y];
        visited = new boolean[X * Y];
        transChess(chessBorad, 0, 0, 1);
        for (int[] ints : chessBorad) {
            for (int step : ints) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }

    }

    public static void transChess(int[][] chessBorad, int row, int column, int step) {

        chessBorad[row][column] = step;
        visited[row * X + column] = true;
        ArrayList<Point> points = next(new Point(column, row));
        //优化排序
        sort(points);
        while (!points.isEmpty()) {
            Point point = points.remove(0);
            if (!visited[point.y * X + point.x]) {
                transChess(chessBorad, point.y, point.x, step + 1);
            }
        }

        if (step < X * Y && !finished) {
            chessBorad[row][column] = 0;
            visited[row * X + column] = false;
        } else {
            finished = true;
        }
    }

    public static ArrayList<Point> next(Point curPoint) {

        ArrayList<Point> points = new ArrayList<>();
        Point p1 = new Point();
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            points.add(new Point(p1));
        }
        return points;

    }

    public static void sort(ArrayList<Point> points) {
        points.sort((o1, o2) -> {
            int size = next(o1).size();
            int size1 = next(o2).size();
            if (size < size1) {
                return -1;

            } else if (size == size1) {
                return 0;
            } else {
                return 1;
            }

        });
    }
}
