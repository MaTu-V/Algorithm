package binarySort;

public class BinaryNodeTree {
    private Node root;

    /**
     * 添加结点
     */
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉遍历树为空!");
        }
    }

    /**
     * 查找要删除的结点
     */
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    /**
     * 查找父节点
     */
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * 查找最小节点 在当前右子树中
     *
     */
    public int delRightTreeMin(Node node){
        Node target = node;
        // 循环查找做左节点 就会找到最小值
        while (target.left != null){
            target = target.left;
        }
        // 这是找到了最小的节点
        delNode(target.value); // 删除最小的节点
        return target.value;  // 返回该target
    }
    /**
     * 删除结点
     */
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            // 获取要删除的结点
            Node targetNode = search(value);
            // 二叉树中不存在该待删除的结点
            if (targetNode == null) {
                return;
            }

            //（判断当前二叉树中是否只有一个结点）
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }

            // 去找到targetNode的父结点
            Node parentNode = searchParent(value);
            /**
             * 如果要删除的结点是叶子结点
             */
            if (targetNode.left == null && targetNode.right == null) {
                // 判断该结点相对于父节点而言 是 左节点 还是右节点
                if (parentNode.left != null && parentNode.left.value == value) {
                    // 左节点
                    parentNode.left = null;
                } else if (parentNode.right != null && parentNode.right.value == value) {
                    parentNode.right = null;
                }
            }
            /**
             * 如果要删除的结点是下面左右节点同时存在
             */
            else if (targetNode.left != null && targetNode.right != null) {
                /**
                 * 思路：
                 *  左右节点均存在
                 *    从右子树中找出最小节点 然后保存起来 删除该最小节点 然后将当前节点的数据替换为临时保存量
                 */
                 int RightTreeMinNodeVal = delRightTreeMin(targetNode.right); // 将右子树传递
                // 让当前待删除结点的内容变为 最小结点的内容
                targetNode.value = RightTreeMinNodeVal;
            } else {
                /**
                 * 仅有一个节点
                 */
                // 存在左子节点
                if (targetNode.left != null) {
                    // 防止当前删除结点的夫系为父节点
                    if (parentNode!=null){
                        // 说明当前待删除节点是父节点的左节点
                        if (parentNode.left.value == value) {
                            parentNode.left = targetNode.left;
                        } else {
                            // 说明当前待删除节点是父节点的右节点
                            parentNode.right = targetNode.left;
                        }
                    }else {
                        root = targetNode.left;
                    }
                } else {
                    if (parentNode!=null){
                        // 存在右子结点
                        if (parentNode.left.value == value) {
                            // 说明当前待删除节点是父节点的左节点
                            parentNode.left = targetNode.right;
                        } else {
                            // 说明当前待删除节点是父节点的右节点
                            parentNode.right = targetNode.right;
                        }
                    }else {
                        root =targetNode.right;
                    }
                }
            }
        }
    }
}
