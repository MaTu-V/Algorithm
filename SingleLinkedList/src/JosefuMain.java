public class JosefuMain {
    public static void main(String[] args) {
        JosefuLinkedList linkedList = new JosefuLinkedList();
        linkedList.addBoy(125); // 环形
        linkedList.printBoy();
        linkedList.countBoy(10,20,125);
    }
}
