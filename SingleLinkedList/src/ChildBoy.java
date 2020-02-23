public class ChildBoy {
    public int no;
    public ChildBoy next;
    public ChildBoy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "ChildBoy{" +
                "no=" + no +
                ", next=" + next +
                '}';
    }
}
