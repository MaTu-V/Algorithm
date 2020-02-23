import java.util.Stack;

public class SingleLinkedList {
    // 初始化一个头节点
    private HeroNode head = new HeroNode(0, "", "");

    // 获取结点头
    public HeroNode getHead() {
        return head;
    }

    // 添加结点 当不考虑编号顺序
    public void add(HeroNode node) {
        // head结点不能动
        HeroNode temp = head; // 获取到头节点信息
        // 找到链表结尾
        while (true) {
            if (temp.next == null)
                break;
            temp = temp.next;
        }
        // 此时temp为链表结尾
        temp.next = node; // 新节点挂载到结尾上
    }

    // 添加结点 按照编号顺序
    public void addOrderNo(HeroNode node) {
        HeroNode temp = head;
        boolean isExist = false;
        // 添加到链表结尾
        while (true) {
            if (temp.next == null) {
                break;
            } else if (temp.next.no > node.no) { // 按顺序插入
                break;
            } else if (temp.next.no == node.no) { // 防止重复编号插入
                isExist = true;
                break;
            }
            temp = temp.next; // 结点下移
        }
        // true 则提示结点已经存在
        if (isExist) {
            System.out.print("该节点已经存在!");
        } else {
            // 插入结点
            node.next = temp.next;
            temp.next = node;
        }
    }

    // 修改结点
    public void updateList(HeroNode node) {
        if (head.next == null) {
            System.out.println("链表为空!");
            return;
        }
        // 找到需要修改的结点，根据no编号
        // 定义一个辅助变量
        HeroNode temp = head.next; // TODO:首结点
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
    public void deleteList(HeroNode node) {
        HeroNode temp = head; // TODO:头节点开始
        boolean flag = false; // 标识是否找到待删除的结点
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 找到待删除的结点
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("未找到待删除结点!");
        }
    }

    // 将单链表反转
    public void reverseList(HeroNode head){
        // 链表为空或者仅有一个结点
        if (head.next == null || head.next.next == null){
            return;
        }

        HeroNode cur = head.next;  // 定义一个辅助的指针变量
        HeroNode next = null; // 当前cur的下一个结点
        // 新链表
        HeroNode reverseHead = new HeroNode(0,"","");
        while (cur != null){
            next = cur.next; // 保存当前结点的下一个结点
            // 先让当前结点连接到 新 队列的 其他结点
            cur.next = reverseHead.next;
            // 再把当前结点挂在到 新队列上
            reverseHead.next = cur;
            cur = next; // 下个结点
        }
        head.next = reverseHead.next; // 单链表反转 保存
    }

    // 获取倒数第k个结点
    public HeroNode getIdxNode(HeroNode head, int idx) {
        if (head.next == null) {
            System.out.println("链表为空!");
        }
        int size = getLength(head); // 计算中长度
        if (idx <= 0 && idx >= size) {
            System.out.println("越界!");
            return null;
        }
        HeroNode temp = head.next;
        for (int i = 0; i < size - idx; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // 统计长度
    public int getLength(HeroNode head) {
        int count = 0;
        if (head.next == null) {
            System.out.println("链表为空!");
        }
        HeroNode temp = head.next; // 当前有效元素
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // 反序打印链表
    public void reversePrint(HeroNode head){
        if (head.next == null){
            System.out.println("链表为空!");
        }
        Stack<HeroNode> s = new Stack<>(); // 创建栈队列
        HeroNode temp = head.next;
        while(temp!=null){
            s.push(temp); // 把当前变量压入栈
            temp = temp.next; // temp后移 继续入栈
        }
        while (s.size() > 0){
            System.out.println(s.pop()); // 弹出栈顶元素
        }
    }
    // 显示链表
    public void printfList() {
        if (head.next == null) System.out.println("链表为空!");
        HeroNode temp = head.next;
        while (true) {
            // 遍历完成
            if (temp == null) break;
            // 输出结点信息
            System.out.println(temp.toString());
            // temp后移
            temp = temp.next;
        }
    }
}
