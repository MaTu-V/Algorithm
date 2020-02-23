package floyd;

import java.util.Arrays;

public class Graph {
    private char[] vertex; // 顶点数组
    private int[][] dis;// 路径
    private int[][] pre; // 前驱

    public Graph(int length, int[][] martrix, char[] vertex) {
        this.vertex = vertex;
        this.dis = martrix;
        this.pre = new int[length][length];
        // 对pre初始化
        for (int i = 0; i < length; i++) {
            //存放对应下标
            Arrays.fill(pre[i], i);
        }
    }

    /**
     * 输出
     */
    public void printfGraph() {
        for (int k = 0; k < dis.length; k++) {
            //显示前驱
            for (int i = 0; i < dis.length; i++) {
                System.out.print(vertex[pre[k][i]] + " ");
            }
            System.out.println();
            // 显示各顶点关系
            for (int i = 0; i < dis.length; i++) {
                System.out.print("(" + vertex[k] + "到" + vertex[i] + "距离：" + dis[k][i] + ")");
            }
            System.out.println();
        }
    }


    /**
     * Floyd
     */
    public void floyd() {
        int len = 0;// 变量保存
        for (int k = 0; k < dis.length; k++) {// 中间顶点
            for (int i = 0; i < dis.length; i++) { // 出发顶点
                for (int j = 0; j < dis.length; j++) { // 终点
                    len = dis[i][k] + dis[k][j]; // i -> k -> j 距离
                    // 通过中间结点 距离变小
                    if (len < dis[i][j]) {
                        dis[i][j] = len; // 替换
                        pre[i][j] = pre[k][j];// 更新j 得 前驱结点
                    }
                }
            }
        }
    }
}
