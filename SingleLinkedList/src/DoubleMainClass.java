public class DoubleMainClass {

    public static void main(String[] args) {
        DoubleHeroNode node_1 = new DoubleHeroNode(1, "宋江", "及时雨");
        DoubleHeroNode node_2 = new DoubleHeroNode(2, "卢俊义", "玉麒麟");
        DoubleHeroNode node_3 = new DoubleHeroNode(3, "吴用", "智多星");
        DoubleHeroNode node_4 = new DoubleHeroNode(4, "林冲", "豹子头");
        DoubleSingleLinkedList linkedList = new DoubleSingleLinkedList();
        linkedList.add(node_1);
        linkedList.add(node_2);
        linkedList.add(node_3);
        linkedList.add(node_4);
        DoubleHeroNode node_2_upd = new DoubleHeroNode(2, "小卢", "玉麒麟");


        linkedList.updateList(node_2_upd);
//        linkedList.deleteList(node_2);
        linkedList.printfList();
    }

}
