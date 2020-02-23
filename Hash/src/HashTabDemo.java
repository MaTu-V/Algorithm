import java.util.ArrayList;
import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        // 创建哈希
        EmpHashTab tab = new EmpHashTab(7);
        Scanner sc = new Scanner(System.in);
        String key = "";
        while (true) {
            System.out.println("add:添加雇员");
            System.out.println("list:打印雇员");
            System.out.println("find:查找雇员");
            key = sc.next();
            switch (key) {
                case "add":
                   for (int i=0;i<15;i++){
                       Emp emp = new Emp(i, "emp_" + i);
                       tab.add(emp);
                   }
                    break;
                case "list":
                    tab.list();
                    break;
                case "find":
                    System.out.println("输入编号:");
                    int fId = sc.nextInt();
                    System.out.println(tab.findEmp(fId));
            }
        }
    }
}
