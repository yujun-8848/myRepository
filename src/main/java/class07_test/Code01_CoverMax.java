package class07_test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yujun
 * @Description 最大线段重合问题
 * 给定很多线段，每个线段都有两个数[start, end]，
 * 表示线段开始位置和结束位置，左右都是闭区间
 * 规定：
 * 1）线段的开始和结束位置一定都是整数值
 * 2）线段重合区域的长度必须>=1
 * 返回线段最多重合区域中，包含了几条线段
 * @Date 2021/11/14
 */
public class Code01_CoverMax {

    public static int maxCover(int[][] arr) {
        Line[] lines = new Line[arr.length];
        for (int i = 0; i < lines.length; i++) {
            //将二维数组转化为指定数据类型
            lines[i] = new Line(arr[i][0], arr[i][1]);
        }
        Arrays.sort(lines, Comparator.comparingInt(o -> o.start));
        //默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        for (Line line : lines) {
            //如果小根堆中的值小于等于线段值的开始位置，则剔除
            //因为end <= start 不相交
            //不属于重合线段
            while (!heap.isEmpty() && heap.peek() <= line.start) {
                heap.poll();
            }
            //小根堆中存储线段的结尾值
            heap.add(line.end);
            max = Math.max(max, heap.size());
        }
        return max;
    }

    public static class Line {
        private final int start;
        private final int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
