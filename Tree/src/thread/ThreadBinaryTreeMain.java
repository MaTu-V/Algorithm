package thread;

public class ThreadBinaryTreeMain {
    public static void main(String[] args) {
        // 创建二叉树
        ThreadBinaryTree tree = new ThreadBinaryTree();
        ThreadHeroNode root = new ThreadHeroNode(1,"tom");
        ThreadHeroNode node_3 = new ThreadHeroNode(3,"jav");
        ThreadHeroNode node_6 = new ThreadHeroNode(6,"smith");
        ThreadHeroNode node_8 = new ThreadHeroNode(8,"mary");
        ThreadHeroNode node_10 = new ThreadHeroNode(10,"king");
        ThreadHeroNode node_14 = new ThreadHeroNode(14,"dim");
        // 二叉树生成
        root.setLeft(node_3);
        root.setRight(node_6);
        node_3.setLeft(node_8);
        node_3.setRight(node_10);
        node_6.setRight(node_14);
        tree.setRoot(root);

        // 线索化
        tree.threadNodes(root);

        // 测试
//        System.out.println(node_8.getRight());
//        System.out.println(node_8.getRightType());
        tree.threadList();
    }
}
