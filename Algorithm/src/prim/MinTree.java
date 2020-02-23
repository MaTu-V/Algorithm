package prim;

import java.util.Arrays;

public class MinTree {
    // 创建矩阵
    public void createGraph(MGraph mGraph, int vertexs, char[] data, int[][] weight) {
        int i, j;
        for (i = 0; i < vertexs; i++) {
            mGraph.data[i] = data[i];
            for (j = 0; j < vertexs; j++) {
                mGraph.weight[i][j] = weight[i][j];
            }
        }
    }

    // 遍历
    public void printfGraph(MGraph graph) {
        for (int[] rows : graph.weight) {
            System.out.println(Arrays.toString(rows));
        }
    }

    /**
     * prim算法 (生成n顶点 n-1 边)
     *
     * @param mGraph
     * @param v 开始点
     */
    public void prim(MGraph mGraph, int v) {
        int[] visited = new int[mGraph.vertexs]; // 标记节点是否被访问过
        visited[v] = 1; // 标记当前节点访问
        int h1 = -1, h2 = -1; // 标记两个节点下标
        int minWeight = 10000; // 最小值
        for (int k = 1; k < mGraph.vertexs; k++) { // 边生成
            // i 标识当前已被标识的节点
            for (int i = 0; i < mGraph.vertexs; i++) {
                // 遍历当前节点对应的其他节点
                for (int j = 0; j < mGraph.vertexs; j++) {
                    // 查找已被访问节点中 对应的还未被访问的节点 从中选择最小的
                    if (visited[i] == 1 && visited[j] == 0 && mGraph.weight[i][j] < minWeight){
                        minWeight = mGraph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }

            // 获取到最小权值点
            // 标记为已经访问过
            System.out.println("边<"+ mGraph.data[h1] +"," + mGraph.data[h2] + ">  对应权值为："+ mGraph.weight[h1][h2] );
            visited[h1] = 1;
            visited[h2] = 1;
            minWeight = 10000;
        }

    }
}
