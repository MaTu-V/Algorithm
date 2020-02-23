public class HeroNode {
    public int no; // 编号
    public String name; // 名称
    public String nickName; // 昵称
    public HeroNode next; // 指向下一个作用域

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }





    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", next=" + next +
                '}';
    }
}
