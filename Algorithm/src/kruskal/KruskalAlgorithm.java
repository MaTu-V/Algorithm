package kruskal;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class KruskalAlgorithm {
    private int edgeNum; // 边数
    private char[] vertexs; // 顶点数组
    private int[][] matrix; // 矩阵
    private static final int INF = Integer.MAX_VALUE; // 最小值

    public static void main(String[] args) {
        char[] vertex = {'A','B','C','D','E','F','G'};
        int[][] matrix =new int[][]{
                {0,12,INF,INF,INF,16,14},
                {12,0,10,INF,INF,7,INF},
                {INF,10,0,3,5,6,INF},
                {INF,INF,3,0,4,INF,INF},
                {INF,INF,5,4,0,2,8},
                {16,7,6,INF,2,0,9},
                {14,INF,INF,INF,8,9,0}
        };
        KruskalAlgorithm kurkal = new KruskalAlgorithm(vertex,matrix);
        kurkal.kruskal();
    }

    /*
     构造器
      */
    public KruskalAlgorithm(char[] vertexs,int[][] matrix){
        int vlen = vertexs.length;
        this.vertexs = new char[vlen];
        for (int i=0;i<vertexs.length;i++){
            this.vertexs[i] = vertexs[i];
        }
        this.matrix = new int[vlen][vlen];
        for (int i=0;i<vlen;i++){
            for (int j=0;j<vlen;j++){
                this.matrix[i][j] = matrix[i][j];
            }
        }
        // 统计边
        for (int i=0;i<vlen;i++){
            // 去掉本身
            for (int j=i+1;j<vlen;j++){
                if (this.matrix[i][j] !=INF){
                    this.edgeNum++; // 边数量统计
                }
            }
        }
    }

    /*
    打印
     */
    public void  printfKruskal(){
        for (int i=0;i<vertexs.length;i++){
            for (int j=0;j<vertexs.length;j++){
                System.out.printf("%11d\t",matrix[i][j]);
            }
            System.out.println();
        }
    }

    /*
    获取对应顶点下标
     */
    public int getIdx(char ch){
        for(int i=0;i<vertexs.length;i++){
            if (vertexs[i] == ch){
                return  i;
            }
        }
        return -1;
    }

    /*
     边 矩阵
     */
    public LinkedList<EData> getEdges(){
        LinkedList<EData> e = new LinkedList<>();
        for (int i=0;i<vertexs.length;i++){
            // 去掉本身
            for (int j= i+ 1;j<vertexs.length;j++){
                if (matrix[i][j]!=INF){
                    e.add(new EData(vertexs[i],vertexs[j],matrix[i][j]));
                }
            }
        }
        Collections.sort(e); // 排序
        return e;
    }
    /**
     * 获取当前点的终点  用于判断是否有回路形成
     * @param ends 记录各个顶点对应的终点（边扫描边添加）
     * @param i 表示传入的顶点对应的下标
     * @return 返回对应终点的下标
     */
    public int getEnd(int[] ends,int i){
        while (ends[i] != 0){
            i = ends[i];
        }
        return i;
    }


    public void kruskal(){
        // ends 长度等于顶点个数
        int[] ends = new int[vertexs.length]; // 保存最小生成树 中 各个顶点对应的终点下标
        LinkedList<EData> result = new LinkedList<>(); // 最终返回
        LinkedList<EData> eData = getEdges();
        // 遍历 eData(已经按照边长度 从小到大排序)
        for (int i=0;i< edgeNum;i++){
            // 获取两点
            int p1 = getIdx(eData.get(i).getStart());
            int p2 = getIdx(eData.get(i).getEnd());
            // 获取两点的终点
            // System.out.println(Arrays.toString(ends));
            int m = getEnd(ends,p1);
            int n = getEnd(ends,p2);
            // 下标一致 则构成回路
            if (m != n){
                ends[m] = n; // 标记该顶点对应的下标
                result.add(eData.get(i)); // 存入该边
            }
        }
        System.out.println(result);
    }
}
