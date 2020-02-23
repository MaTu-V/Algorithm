package hourse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Hourse {
    private static int X; // 行数
    private static int Y; // 列数
    private static boolean visited[]; // 标记棋盘所有位置是否都被访问过
    private static boolean finished; // 如果为true 则表示成功

    public static void main(String[] args) {
        X = 8;
        Y = 8;
        int row = 1;
        int col = 1;
        int[][] chess = new int[X][Y];
        visited = new boolean[X * Y]; // 大小
        Long start = System.currentTimeMillis();
        house(chess, row - 1, col - 1, 1);
        Long end = System.currentTimeMillis();
        System.out.println(start - end);
        // 输出棋盘
        for (int[] rows : chess) {
            System.out.println(Arrays.toString(rows));
        }
    }

    /**
     * 马踏棋盘
     *
     * @param chess 棋盘
     * @param row   当前马儿 行位置
     * @param col   当前马儿 列位置
     * @param step  当前所走步数
     */
    public static void house(int[][] chess, int row, int col, int step) {
        chess[row][col] = step; // 改变 表示当前为第 step 步
        visited[row * X + col] = true; // 标记当前位置访问过
        // 或许当前位置可以走的下一个位置的集合
        ArrayList<Point> ps = next(new Point(col, row)); // 对应关系
        // 贪心
        sort(ps);
        // 遍历 ps
        while (!ps.isEmpty()) {
            Point p = ps.remove(0); // 取出一个可走位置
            // 判断是否访问过
            // 未被访问 则 继续走
            if (!visited[p.y * X + p.x]) {
                house(chess, p.y, p.x, step + 1);
            }
        }
        // 判断是否完成任务
        if (step < X * Y && !finished) {
            // 说明还未完成
            chess[row][col] = 0;
            visited[row * X + col] = false;
        } else {
            finished = true;
        }
    }

    /**
     * 获取当前点的下一步可走路径
     *
     * @param curPoint
     * @return
     */
    public static ArrayList<Point> next(Point curPoint) {
        // 返回可以走的所有点
        ArrayList<Point> ps = new ArrayList<>();
        // 创建下一步走的点
        Point next = new Point();
        // 判断是否可以走左上
        if ((next.x = curPoint.x - 2) >= 0 && (next.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(next));
        }
        if ((next.x = curPoint.x - 1) >= 0 && (next.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(next));
        }
        // 判断是否可以走右上
        if ((next.x = curPoint.x + 1) < X && (next.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(next));
        }
        if ((next.x = curPoint.x + 2) < X && (next.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(next));
        }
        // 判断是否可以走右下
        if ((next.x = curPoint.x + 1) < X && (next.y = curPoint.y + 2) < Y) {
            ps.add(new Point(next));
        }
        if ((next.x = curPoint.x + 2) < X && (next.y = curPoint.y + 1) < Y) {
            ps.add(new Point(next));
        }
        // 判断是否可以走左下
        if ((next.x = curPoint.x - 2) >= 0 && (next.y = curPoint.y + 1) < Y) {
            ps.add(new Point(next));
        }
        if ((next.x = curPoint.x - 1) >= 0 && (next.y = curPoint.y + 2) < Y) {
            ps.add(new Point(next));
        }
        return ps;
    }

    /**
     * 为降低时间复杂度  使用贪心
     *  即 先走当前位置的下一步 走尽可能少的步骤
     *  根据当前这步的下一步的位置 进行非递减排序
     */
    public static void sort(ArrayList<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int count_1 = next(o1).size();
                int count_2 = next(o2).size();
                if (count_1 < count_2){
                    return  -1;
                }else if (count_1 == count_2){
                    return  0;
                }else {
                    return  1;
                }
            }
        });
    }
}
