package avl;

/**
 * 创建结点
 */
public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 返回左子树的高度
     */
    public int leftHeight(){
        if (left == null){
            return 0;
        }
        return left.height();
    }
    /**
     * 返回右子树的高度
     */
    public int rightHeight(){
        if (right == null){
            return 0;
        }
        return right.height();
    }

    /**
     * 左旋转
     */
    public void leftRotate(){

        /**
         * 思路
         *  0) 创建新节点 为当前跟节点的值
         *  1) 把新节点的左子树 设置为当前节点的左子树
         *  2) 把新节点的右子数 设置为当前节点的右子树的左子树
         *  3) 把当前节点的值换为 右子节点的值
         *  4) 把当前节点的右子树 设置为 右子树的右子树
         *  5) 把当前节点的左子树 设置为新节点
         */
        Node tempNode = new Node(value);
        tempNode.left = left;
        tempNode.right = right.left;
        value = right.value;
        right = right.right;
        left = tempNode;
    }
    /**
     * 右旋转
     */
    public void rightRotate(){
        Node tempNode = new Node(value);
        tempNode.right =right;
        tempNode.left = left.right;
        value = left.value;
        left = left.left;
        right = tempNode;
    }
    /**
     * 查找当前节点的高度,以该节点为根节点的高度
     */
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    /**
     * 添加二叉结点
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (this.value > node.value) {
            // 遍历左侧
            // 判断传入结点的值  和当前子树的根节点的值关系
            if (this.left == null) {
                this.left = node; // 为空直接挂载
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node; // 为空直接挂载
            } else {
                this.right.add(node);
            }
        }


        // 旋转
        if (rightHeight() - leftHeight() > 1){
            // 如果右子树的左子树 大于 它的右子树的高度
            if (right!=null && right.leftHeight() > right.rightHeight()){
                // 先右旋转
                right.rightRotate();
                // 左旋转
                leftRotate();
            }else {
                leftRotate();
            }
            return;
        }

        if (leftHeight() - rightHeight() > 1 ){
            // 如果左子树的右子树 大于 它的左子树的高度
            if (left!=null && left.rightHeight() > left.leftHeight()){
                // 对当前节点的左节点进行左旋转
                left.leftRotate();
                // 对当前节点的进行右旋转
                rightRotate();
            }else {
                // 直接右旋转
                rightRotate();
            }
        }
    }


    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 查找删除结点
     *
     * @return
     */
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            // 左侧查找
            if (this.left == null) {
                return null;
            } else {
                return this.left.search(value);
            }
        } else {
            // 右侧查找
            if (this.right == null) {
                return null;
            } else {
                return this.right.search(value);
            }
        }
    }

    /**
     * 查找删除结点的父节点
     *
     * @return
     */
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value)
                || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            // 朝朝的值小于当前结点的值， 并且当前结点的左节点不为空
            if (this.left != null && value < this.value) {
                // 左侧查找
                return this.left.searchParent(value);
            } else if (this.right != null && value > this.value) {
                // 右侧查找
                return this.right.searchParent(value);
            } else {
                // 没有父节点
                return null;
            }
        }
        // 获取到父节点
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
