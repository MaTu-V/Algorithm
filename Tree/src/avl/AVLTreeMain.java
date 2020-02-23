package avl;

/**
 * AVL平衡二叉树
 */
public class AVLTreeMain {
    public static void main(String[] args) {
//        int[] arr = {4,3,6,5,7,8};
        int[] arr = {10,12,8,9,7,6};
        AVLTree tree = new AVLTree();
        for (int i=0;i<arr.length;i++){
            tree.add(new Node(arr[i]));
        }
        tree.infixOrder();
        // 树高度
        System.out.println(tree.getRoot().height());
        // 左子树高度
        System.out.println(tree.getRoot().left.height());
        // 右子树高度
        System.out.println(tree.getRoot().right.height());
        System.out.println(tree.getRoot());
    }
}
