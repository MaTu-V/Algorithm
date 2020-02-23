package thread;

/**
 * 线索化二叉树
 *    按照某种顺寻遍历时刻 左结点 或者 右节点为空
 *    则让他指向按该遍历顺序的前一个或者后一个节点 成为前继或者后继节点
 */
public class ThreadBinaryTree {
    private ThreadHeroNode root;
    private ThreadHeroNode prev; // 前一个
    public void setRoot(ThreadHeroNode root){
        this.root =root;
    }

    /**
     * 线索化
     * @param node
     */
    public void threadNodes(ThreadHeroNode node){
        // 为空则不能线索化
        if (node == null){
            return;
        }

        // 先线索化当前左子树
        threadNodes(node.getLeft());
        // 线索化当前结点
        // 左子针为空
        if (node.getLeft() == null){
            node.setLeft(prev);
            node.setLeftType(1); // 标记当前结点的prev为 前继结点
        }
        // 当前结点的右子针为空
        // 先暂停 不动
        // 当循环到下一个结点的时刻
        // 去检测上个节点的右指针是否为空
        // 为空则让他指向我
        if (prev !=null && prev.getRight() == null){
            prev.setRight(node);
            prev.setRightType(1);
        }

        prev = node; // 当前节点 已经线索化 让其成为前一个结点
        // 线索化右子树
        threadNodes(node.getRight());
    }

    /**
     * 遍历
     */
    public void threadList(){
        ThreadHeroNode node = root;
        while (node!=null){
            // 遍历 先获取 最先输出结点
            while (node.getLeftType() == 0){
                node = node.getLeft();
            }
            // 打印当前结点
            System.out.println(node); // 该节点类型为1
            // 如果当前结点的右指针
            while (node.getRightType() == 1){
                // 获取当前结点的后记结点
                node = node.getRight();
                // 内部打印 否则 将会输出上次结点 重复打印

                System.out.println(node); // 输出当前结点
            }
            // 替换
            node = node.getRight();
        }
    }

}
