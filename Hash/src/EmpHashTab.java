public class EmpHashTab {
    private int size;
    private EmpLinkedList[] linkedList;

    /**
     * 初始化
     *
     * @param size
     */
    public EmpHashTab(int size) {
        this.size = size;
        this.linkedList = new EmpLinkedList[size];
        // 初始化 创建
        for (int i = 0; i < size; i++) {
            linkedList[i] = new EmpLinkedList();
        }
    }

    /**
     * 添加
     *
     * @param e
     */
    public void add(Emp e) {
        int idx = hashCode(e.getId()); // 获取位置
        this.linkedList[idx].add(e); // 添加
    }

    /**
     * 遍历
     */
    public void list() {
        for (int i = 0; i < linkedList.length; i++) {
            linkedList[i].list(i); // 输出
        }
    }

    /**
     * 查找
     */
    public Emp findEmp(int id) {
        int idx = hashCode(id); // 获取链表位置
        return linkedList[idx].findEmp(id);
    }

    /**
     * 取模 生成插入链位置
     *
     * @return
     */
    public int hashCode(int id) {
        return id % this.size;
    }
}
