public class ArrBinaryTree {
    private int[] arr; // 存储数据结点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 存储后  前序遍历
     */
    public void prevOrder(int index){
        if (arr == null || arr.length ==0 ){
            System.out.println("数组为空!");
            return;
        }

        // 输出当前元素
        System.out.println(arr[index]);
        // 左递归
        if (index * 2 + 1 < arr.length){
            prevOrder(index * 2 + 1);
        }
        // 右递归
        if (index * 2 + 2 < arr.length){
            prevOrder(index * 2 + 2);
        }
    }
    /**
     * 存储后  中序遍历
     */
    public void infixOrder(int index){
        if (arr == null || arr.length ==0 ){
            System.out.println("数组为空!");
            return;
        }
        // 左递归
        if (index * 2 + 1 < arr.length){
            infixOrder(index * 2 + 1);
        }
        // 输出当前元素
        System.out.println(arr[index]);
        // 右递归
        if (index * 2 + 2 < arr.length){
            infixOrder(index * 2 + 2);
        }
    }
    /**
     * 存储后  前序遍历
     */
    public void postOrder(int index){
        if (arr == null || arr.length ==0 ){
            System.out.println("数组为空!");
            return;
        }
        // 左递归
        if (index * 2 + 1 < arr.length){
            postOrder(index * 2 + 1);
        }
        // 右递归
        if (index * 2 + 2 < arr.length){
            postOrder(index * 2 + 2);
        }
        // 输出当前元素
        System.out.println(arr[index]);

    }
}
