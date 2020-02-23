public class JosefuLinkedList {
    // 首节点
    private ChildBoy first = null;

    /**
     * 添加孩子结点
     *
     * @param num
     */
    public void addBoy(int num) {
        if (num <= 0) {
            System.out.println("num数量不正确");
            return;
        }

        ChildBoy temp = null;  // 临时变量
        // 创建环形列表
        for (int i = 1; i <= num; i++) {
            // 根据编号创建
            ChildBoy boy = new ChildBoy(i);
            if (first == null) { //单元素环形链
                first = boy;
                first.next = first;
                temp = boy; // 临时变量
            }
            // 其他结点
            temp.next = boy; // 闭环回路
            boy.next = first;
            temp = boy; // 临时变量下移
        }
    }

    /**
     * 小孩出圈
     *
     * @param startNo  开始小孩位置
     * @param countNum 待 数数字
     * @param nums     最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("输入不合理!");
            return;
        }
        // 创建辅助指针 完成小孩出圈
        ChildBoy helper = first;
        // 获取最后一个小孩的位置
        while (true) {
            if (helper.next == first) {
                // 小孩出圈
                break;
            }
            helper = helper.next;
        }

        // 报数前 初始化对应位置
        for (int i = 0; i < startNo - 1; i++) {
            first = first.next; // 找到报数小孩
            helper = helper.next; // 找到 报数小孩的后面一个孩子
        }

        // 出圈
        while (true) {
            // 仅剩下一个人
            if (helper == first) {
                System.out.println("win:"+first.no);
                break;
            }
            // 开始报数
            for (int i = 0; i < countNum - 1; i++) {
                first = first.next;
                helper = helper.next;
            }
            // first指向出圈的结点
            System.out.println("fail:"+first.no);
            first = first.next; // 小孩出圈
            helper.next=first; // 连接
        }
    }

    /**
     * 打印
     */
    public void printBoy() {
        if (first == null) {
            System.out.println("链表为空!");
            return;
        }
        // 临时变量
        ChildBoy temp = null;
        temp = first;
        while (true) {
            System.out.printf("第%d个小孩\n", temp.no);
            if (temp.next == first) {
                // 遍历完
                break;
            }
            temp = temp.next; // 指针后移
        }
    }

}
