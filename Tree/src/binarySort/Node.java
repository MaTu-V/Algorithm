package binarySort;

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
     * @return
     */
    public Node searchParent(int value){
        if ((this.left!=null && this.left.value == value)
                ||(this.right!=null && this.right.value == value)){
            return this;
        }else {
            // 朝朝的值小于当前结点的值， 并且当前结点的左节点不为空
            if (this.left!=null && value < this.value){
                // 左侧查找
                return this.left.searchParent(value);
            }else if (this.right!=null && value > this.value){
                // 右侧查找
                return this.right.searchParent(value);
            }else {
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
