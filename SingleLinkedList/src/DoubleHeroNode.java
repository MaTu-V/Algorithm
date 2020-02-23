public class DoubleHeroNode {
    public int no; // 编号
    public String name; // 名称
    public String nickName; // 昵称
    public DoubleHeroNode prev; // 前一个作用域
    public DoubleHeroNode next; // 指向下一个作用域
    public DoubleHeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
        this.prev = null;
        this.next = null;
    }


    @Override
    public String toString() {
        return "DoubleHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", prev=" + prev +
                '}';
    }
}
