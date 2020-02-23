package basic;

public class GraphMain {
    public static void main(String[] args) {
        int n = 8;
        Graph graph = new Graph(n);
        String[] vertexs = {"A","B","C","D","E","F","G","H"};
        //添加
        for (String vertex:vertexs){

            graph.insertVertex(vertex);
        }
        // 添加边
        // AB AC BC BD BE
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        graph.insertEdge(3,7,1);
        graph.insertEdge(4,7,1);
        graph.insertEdge(2,5,1);
        graph.insertEdge(2,6,1);
        graph.insertEdge(5,6,1);
//        graph.printfGraph();
        graph.dfs();
//        graph.bfs();
    }
}
