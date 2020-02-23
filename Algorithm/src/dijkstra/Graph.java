package dijkstra;

import java.util.Arrays;

public class Graph {
    private char[] vertex;
    private int[][] matrix;
    private VisitedVertex vv; // 已经访问过顶点的集合

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void printfGraph() {
        for (int[] rows : matrix) {
            System.out.println(Arrays.toString(rows));
        }
    }

    /**
     * dsj 算法
     *
     * @param idx 出发点下标
     */
    public void dsj(int idx) {
        vv = new VisitedVertex(vertex.length, idx);
        updIdx(idx); // 跟新idx顶点到周围顶点的距离
        int j = 1;
        while (j<vertex.length){
            // 每走一次 选择一个新的顶点
            int index = vv.nextVertex(); // 获取新的访问顶点
            updIdx(index);
            j++;
        }
        vv.showAll();
    }

    /**
     * 更新当前idx顶点到周围点的距离和前驱
     *
     * @param idx
     */
    public void updIdx(int idx) {
        int len = 0;
        // 获取当前顶点到其他顶点的信息


        // 判断通过该idx点到 各点的距离
        // 与  出发顶点到各点的距离
        // 如果路途中该点未被访问过 而且 对应路径最小就更新
        for (int i = 0; i < matrix[idx].length; i++) {
            len = vv.getDis(idx) + matrix[idx][i]; //  当前idx顶点与出发顶点的距离 + 离下一个 j 点的距离
            if (!vv.in(i) && len < vv.getDis(i)) {
                vv.updPre(i, idx); // 将 i 点的前驱修改为当前 idx
                vv.updDis(i, len); // 出发顶 到 i 点的距离替换
            }
        }
    }

}
