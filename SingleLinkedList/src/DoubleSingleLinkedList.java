
public class DoubleSingleLinkedList {
    // 初始化一个头节点
    private DoubleHeroNode head = new DoubleHeroNode(0, "", "");

    // 获取结点头
    public DoubleHeroNode getHead() {
        return head;
    }

    // 添加结点 当不考虑编号顺序
    public void add(DoubleHeroNode node) {
        // head结点不能动
        DoubleHeroNode temp = head; // 获取到头节点信息
        // 找到链表结尾
        while (true) {
            if (temp.next == null)
                break;
            temp = temp.next;
        }
        // 此时temp为链表结尾
        temp.next = node; // 新节点挂载到结尾上
        node.prev = temp; // 新节点指向之前
    }

    // 修改结点
    public void updateList(DoubleHeroNode node) {
        if (head.next == null) {
            System.out.println("链表为空!");
            return;
        }
        // 找到需要修改的结点，根据no编号
        // 定义一个辅助变量
        DoubleHeroNode temp = head.next; // TODO:首结点
        boolean flag = false; // 表示是否找到该节点
        while (true) {
            if (temp == null) {
                break; // 链表遍历结束
            }
            if (temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 找到结点
        if (flag) {
            temp.name = node.name;
            temp.nickName = node.nickName;
        } else {
            System.out.println("不存在");
        }
    }

    // 删除结点
    public void deleteList(DoubleHeroNode node) {
        if (head.next == null){
            System.out.println("链表为空!");
            return;
        }

        DoubleHeroNode temp = head.next; // TODO:头节点开始
        boolean flag = false; // 标识是否找到待删除的结点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 找到待删除的结点
        if (flag) {
            // 防止当前删除结点为最后一个结点而导致空指针异常
            if (temp.next!=null)
              temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
        } else {
            System.out.println("未找到待删除结点!");
        }
    }

    // 显示链表
    public void printfList() {
        if (head.next == null) System.out.println("链表为空!");
        DoubleHeroNode temp = head.next;
        while (true) {
            // 遍历完成
            if (temp == null) break;
            // 输出结点信息
            System.out.println(temp.toString());
//             temp后移
            temp = temp.next;
        }
    }
}
