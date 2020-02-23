package dijkstra;

import java.util.Arrays;

public class VisitedVertex {
    public int[] already_vertex; // 是否被访问过
    public int[] pre_visited; // 前缀顶点
    public int[] dis;// 路径

    public VisitedVertex(int length,int idx){
        this.already_vertex = new int[length];
        this.pre_visited = new int[length];
        this.dis= new int[length];
        // 初始化填充
        Arrays.fill(this.dis,65535);
        this.already_vertex[idx] = 1; // 设置出发顶点被访问过
        this.dis[idx] = 0; // 初始化 顶点路径为 0
    }

    /**
     * 判断该idx 对应顶点是否被访问过
     * @param idx
     * @return
     */
    public boolean in(int idx){
        return already_vertex[idx] == 1; // 1 则 访问过
    }

    /**
     * 更新dis路径
     * @param idx
     * @param len
     */
    public void updDis(int idx,int len){
        dis[idx] = len; // 长度
    }

    /**
     * 更新 该顶点的前驱顶点
     * @param prev
     * @param idx
     */
    public void updPre(int prev,int idx){
        pre_visited[prev] = idx;
    }

    /**
     * 返回出发顶点到idx的距离
     * @param idx
     * @return
     */
    public int getDis(int idx){
        return dis[idx];
    }


    /**
     * 返回新的顶点
     * @return
     */
    public int nextVertex(){
        int min = 65535;
        int idx = 0;
        for (int i=0;i<already_vertex.length;i++){
            // 从未被访问过得顶点中选择最小
            if (already_vertex[i]==0 && dis[i] < min){
                min = dis[i];
                idx = i;
            }
        }
        // 标记当前顶点已经访问
        already_vertex[idx] = 1;
        return idx;
    }

    /**
     * 显示
     */
    public void showAll(){
        System.out.println(Arrays.toString(already_vertex));
        System.out.println(Arrays.toString(pre_visited));
        System.out.println(Arrays.toString(dis));
    }
}
