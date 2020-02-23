/**
 * 链表
 */
public class EmpLinkedList {
    private Emp head; // 头

    /**
     * 添加
     * @param e
     */
    public void add(Emp e){
        if(head == null){
            head = e;
            return;
        }
        Emp eTemp = head;
        while (true){
            if (eTemp.getNext() == null){
                break;
            }
            eTemp = eTemp.getNext();
        }
        eTemp.setNext(e); //挂载到末尾
    }

    /**
     * 遍历
     */
    public void list(int i){
        if (head == null){
            System.out.println(i + "=>{}");
            return;
        }
        Emp eTemp = head;
        System.out.print("第" + i + "链=>");
        while (true){
            System.out.print(eTemp.toString());
            if (eTemp.getNext() == null){
              break;
            }
            System.out.print("\t=>\t");
            eTemp = eTemp.getNext();
        }
        System.out.println();
    }

    /**
     * 查找
     */
    public Emp findEmp(int id){
        if (head == null){
            System.out.println(id + "=>{}");
            return null;
        }
        Emp eTemp = head;
        while (true){
            if (eTemp.getId() == id){
                break;
            }
            if (eTemp.getNext() == null){
                eTemp = null; // 空
                break;
            }
            eTemp =eTemp.getNext(); // 后移
        }
        return eTemp;
    }
}
