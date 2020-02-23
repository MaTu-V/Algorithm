package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 图
 */
public class Graph {
    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOfEdges;
    private boolean[] isVisited;
    /**
     * 初始化
     *
     * @param n
     */
    public Graph(int n) {
        vertexList = new ArrayList<>(n);
        edges = new int[n][n];
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    /**
     * 添加边
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    /**
     * 获取顶点个数
     */
    public int getVertex() {
        return vertexList.size();
    }

    /**
     * 获取边数
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * 返回对应顶点字符
     */
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    /**
     * 返回两个点之间的权值
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    /**
     * 插入顶点
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 显示图矩阵
     */
    public void printfGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 获取下一个点
     */
    public int getFirstNeighbor(int index){
        for (int j=0;j<vertexList.size();j++){
            if (edges[index][j] >0){
                return j;
            }
        }
        return -1;
    }

    /**
     *
     * @param v1 当前点
     * @param v2 已经被访问过的点
     * @return
     */
    public int getNextNeighbor(int v1,int v2){
        for (int j=v2+1;j<vertexList.size();j++){
            if (edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }

    /**
     * 深度遍历当前顶点
     * @param isVisited
     * @param i
     */
    public void dfs(boolean[] isVisited,int i){
        System.out.print(getValueByIndex(i) + "->" + "\t");
        isVisited[i] = true; // 标记已经呗访问过
        int w = getFirstNeighbor(i);
        while (w != -1){
            // 说明存在
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            // 如果被访问过 查找下一个节点
            w = getNextNeighbor(i,w);
        }
    }

    /**
     * 遍历
     */
    public void dfs(){
        for (int i=0;i<getVertex();i++){
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }


    /**
     * 对一个顶点进行广度优先遍历
     */
    public void bfs(boolean[] isVisited,int i){
        int u; // 标识队列的头节点下标
        int w; // 邻接顶点
        // 节点访问顺序队列
        LinkedList queue =new LinkedList<>();
        // 访问该节点
        System.out.print(getValueByIndex(i) + " ->");
        isVisited[i] = true; // 标记访问过
        queue.addLast(i); // 放入队列
        while (!queue.isEmpty()){
            // 取出头

            u = (Integer) queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w!= -1){
                // 可以连接
                if (!isVisited[w]){
                    System.out.print(getValueByIndex(w) + " ->");
                    // 未访问过
                    // 标记访问
                    isVisited[w] = true;
                    queue.addLast(w);
                }

                // 已经访问过 则寻找下一个
                w = getNextNeighbor(u,w);
            }
        }
    }

    /**
     * 广度
     */
    public void bfs(){
        for (int i=0;i<getVertex();i++){
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }
}
