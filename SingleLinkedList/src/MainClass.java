public class MainClass {

    public static void main(String[] args) {
        HeroNode node_1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node_2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node_3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node_4 = new HeroNode(4, "林冲", "豹子头");
        SingleLinkedList linkedList = new SingleLinkedList();
//        linkedList.add(node_1);
//        linkedList.add(node_2);
//        linkedList.add(node_3);
//        linkedList.add(node_4);
        linkedList.addOrderNo(node_3);
        linkedList.addOrderNo(node_1);
        linkedList.addOrderNo(node_4);
        linkedList.addOrderNo(node_2);
//        HeroNode node_2_upd = new HeroNode(2, "小卢", "玉麒麟");
//        linkedList.updateList(node_2_upd);
//        linkedList.deleteList(node_1);
//        linkedList.getLength(linkedList.getHead());
//        System.out.println(linkedList.getIdxNode(linkedList.getHead(),3));
//        linkedList.printfList();
//        System.out.println();
//        linkedList.reverseList(linkedList.getHead());
        linkedList.reversePrint(linkedList.getHead());
//        linkedList.printfList();

    }

}
