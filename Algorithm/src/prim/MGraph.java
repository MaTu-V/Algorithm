package prim;

/**
 * 顶点信息
 */
public class MGraph {
    int vertexs; // 顶点个数
    char[] data; // 存放节点数据
    int[][] weight; // 存放边
    //初始化
    public MGraph(int vertexs){
        this.vertexs = vertexs;
        data = new char[vertexs];
        weight = new int[vertexs][vertexs];
    }
}
