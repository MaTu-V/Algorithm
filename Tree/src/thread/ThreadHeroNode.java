package thread;

public class ThreadHeroNode {
    private int no;
    private String name;
    private ThreadHeroNode left;
    private ThreadHeroNode right;
    // 如果 ==0 则代表指向左子树  ==1 代表指向右子树
    private int leftType;
    // 如果 ==0 则代表指向右子树  ==1 代表指向左子树
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public ThreadHeroNode(int no, String name) {
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

    public ThreadHeroNode getLeft() {
        return left;
    }

    public void setLeft(ThreadHeroNode left) {
        this.left = left;
    }

    public ThreadHeroNode getRight() {
        return right;
    }

    public void setRight(ThreadHeroNode right) {
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



}
