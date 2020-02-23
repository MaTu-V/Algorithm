public class ArrayBinaryTreeMain {
    public static void main(String[] args) {
        int[] arr = { 1,2,3,4,5,6,7};
        ArrBinaryTree tree = new ArrBinaryTree(arr);
//        tree.prevOrder(0);
//        tree.infixOrder(0);
        tree.postOrder(0);
    }
}
