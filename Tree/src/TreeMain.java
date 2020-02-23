public class TreeMain {
    public static void main(String[] args) {
        // 创建二叉树
        BinaryTree tree = new BinaryTree();
        HeroNode root = new HeroNode(1,"松江");
        HeroNode node_2 = new HeroNode(2,"无用");
        HeroNode node_3 = new HeroNode(3,"卢俊义");
        HeroNode node_4 = new HeroNode(4,"林冲");

        HeroNode node_5 = new HeroNode(5,"关胜");
        // 二叉树生成
        root.setLeft(node_2);
        root.setRight(node_3);
        node_3.setLeft(node_5);
        node_3.setRight(node_4);
        tree.setRoot(root);
//         前序遍历
//        System.out.println("前序遍历：");
//        tree.prevOrder();
//        // 中序遍历
//        System.out.println("中序遍历：");
//        tree.infixOrder();
//        // 后序遍历
//        System.out.println("后序遍历：");
//        tree.postOrder();

//        System.out.println("前序遍历查找：");
//        HeroNode resNode = tree.prevOrderSearch(5);
//        System.out.println(resNode);
//        System.out.println("中序遍历查找：");
//        HeroNode resNode = tree.infixOrderSearch(5);
//        System.out.println(resNode);
//        System.out.println("后序遍历查找：");
//        HeroNode resNode = tree.postOrderSearch(5);
//        System.out.println(resNode);
        System.out.println("前序遍历：");
        tree.prevOrder();
        tree.delNode(3);
        System.out.println("前序遍历(删除后)：");
        tree.prevOrder();
    }
}
