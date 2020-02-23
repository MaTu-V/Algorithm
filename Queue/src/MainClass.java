import java.util.Scanner;

/**
 * 数组队列测试
 */
public class MainClass {
    public static void main(String[] args) {
       ArrayQueue queue = new ArrayQueue(3);
       Scanner scanner = new Scanner(System.in);
       char key = ' '; // 用户接收
       boolean loop = true;
       while (loop){
           System.out.println("s:显示队列");
           System.out.println("a:加入队列");
           System.out.println("h:遍历队列");
           System.out.println("g:取出队列数据");
           key = scanner.next().charAt(0);
           switch (key){
               case 's':
                   try {
                       queue.printQueue();
                   }catch (RuntimeException e){
                       System.out.println(e.getMessage());
                   }
                   break;
               case 'a':
                   try {
                       queue.addQueue(scanner.nextInt());
                   }catch (RuntimeException e){
                       System.out.println(e.getMessage());
                   }
                   break;
               case 'h':
                   try {
                       System.out.println(queue.getHeadQueue());
                   }catch (RuntimeException e){
                       System.out.println(e.getMessage());
                   }
                   break;
               case 'g':
                   try {
                       System.out.println(queue.getQueue());
                   }catch (RuntimeException e){
                       System.out.println(e.getMessage());
                   }
                   break;
               default:
                   loop = false;
                   break;
           }
       }
    }
}
