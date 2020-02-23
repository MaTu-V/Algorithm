package huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffManTreeMain {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node node = createHuffManTree(arr);
        node.prevOrder();
    }

    //创建赫夫曼树
    public static Node createHuffManTree(int[] arr) {
        List<Node> nodes = new ArrayList<>();
        // 作为node结点存入
        for (int val : arr) {
            nodes.add(new Node(val));
        }

        while (nodes.size() > 1) {
            // 排序从小打大
            Collections.sort(nodes);
            // 取出权值最小的二叉树结点
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            // 构建一个新的node 结点
            Node temp = new Node(left.value + right.value);
            temp.left = left;
            temp.right = right;
            nodes.remove(left); // 删除结点
            nodes.remove(right); // 删除结点
            nodes.add(temp); // 加入新节点
        }
        // 最终仅剩下一个结点
        return nodes.get(0);
    }
}
