/**
 * 结点
 */
public class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 前序遍历
     */
    public void prevOrder() {
        System.out.println(this); // 先输出当前节点
        // 递归
        // 左侧不为空
        if (this.left != null) {
            this.left.prevOrder();
        }
        // 右侧不为空
        if (this.right != null) {
            this.right.prevOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {

        // 递归
        // 左侧不为空
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this); // 先输出当前节点
        // 右侧不为空
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {

        // 递归
        // 左侧不为空
        if (this.left != null) {
            this.left.postOrder();
        }
        // 右侧不为空
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this); // 先输出当前节点
    }


    /**
     * 前序遍历查找
     */
    public HeroNode prevOrderSearch(int no) {
        System.out.println("enter_prev");
        if (this.no == no) {
            return this;
        }
        // 临时量
        HeroNode resNode = null;
        if (this.left != null) {
            // 左侧遍历
            resNode = this.left.prevOrderSearch(no);
        }
        if (resNode != null) {
            //找到返回
            return resNode;
        }
        if (this.right != null) {
            // 右侧遍历
            resNode = this.right.prevOrderSearch(no);
        }
        return resNode;
    }

    /**
     * 中序遍历查找
     */
    public HeroNode infixOrderSearch(int no) {


        // 临时量
        HeroNode resNode = null;
        if (this.left != null) {
            // 左侧遍历
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            //找到返回
            return resNode;
        }
        System.out.println("enter_infix");
        if (this.no == no) {
            return this;
        }

        if (this.right != null) {
            // 右侧遍历
            resNode = this.right.infixOrderSearch(no);
        }

        return resNode;
    }

    /**
     * 后序遍历查找
     */
    public HeroNode postOrderSearch(int no) {


        // 临时量
        HeroNode resNode = null;
        if (this.left != null) {
            // 左侧遍历
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            //找到返回
            return resNode;
        }
        if (this.right != null) {
            // 右侧遍历
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            //找到返回
            return resNode;
        }
        System.out.println("enter_post");
        if (this.no == no) {
            resNode = this;
        }
        return resNode;
    }


    /**
     * 删除结点
     */

    public void delNode(int no) {
        // 单向二叉树 删除结点 应当先找到待删除结点的父结点
        if (this.left != null && this.left.no == no) {
            // 找到当前删除结点
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        // 向左侧递归
        if (this.left!=null){
            this.left.delNode(no);
        }
        // 向右侧递归
        if (this.right!=null){
            this.right.delNode(no);
        }
    }
}
