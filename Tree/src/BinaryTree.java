public class BinaryTree {
    private HeroNode root;

    // 根节点
    public void setRoot(HeroNode root) {
        this.root = root;
    }


    /**
     * 前序遍历
     */
    public void prevOrder(){
        if (root!=null){
            root.prevOrder();
        }else {
            System.out.println("二叉树为空!");
        }
    }
    /**
     * 中序遍历
     */
    public void infixOrder(){
        if (root!=null){
            root.infixOrder();
        }else {
            System.out.println("二叉树为空!");
        }
    }
    /**
     * 后序遍历
     */
    public void postOrder(){
        if (root!=null){
            root.postOrder();
        }else {
            System.out.println("二叉树为空!");
        }
    }

    /**
     * 前序遍历查找
     */
    public HeroNode prevOrderSearch(int no){
        if (root!=null){
            return root.prevOrderSearch(no);
        }else {
            return null;
        }
    }
    /**
     * 中序遍历查找
     */
    public HeroNode infixOrderSearch(int no){
        if (root!=null){
            return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }
    /**
     * 后序遍历查找
     */
    public HeroNode postOrderSearch(int no){
        if (root!=null){
            return root.postOrderSearch(no);
        }else {
            return null;
        }
    }

    /**
     * 删除结点
     */
    public void delNode(int no){
        if (root!=null){
            // 判断root是不是待删除结点
            if (root.getNo() == no){
                root = null;
            }else {
                // 递归删除
                root.delNode(no);
            }
        }else {
            System.out.println("二叉树为空!");
        }
    }
}
