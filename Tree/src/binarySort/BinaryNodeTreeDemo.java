package binarySort;

public class BinaryNodeTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9,2};
        BinaryNodeTree tree = new BinaryNodeTree();
        for (int i=0;i<arr.length;i++){
            tree.add(new Node(arr[i]));
        }
//        tree.infixOrder();
        tree.delNode(7);
        tree.infixOrder();
    }
}
