package huffman;

/**
 * 创建结点
 *  为了 让Node 对象持续排序 实现 Compareable接口
 */
public class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        // 排序规则  按照大小
        // 从小到大 （反之）
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }


    /**
     * 前序遍历
     */
    public void prevOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.prevOrder();
        }
        if (this.right!=null){
            this.right.prevOrder();
        }
    }
}
