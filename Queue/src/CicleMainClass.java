import java.util.Scanner;

public class CicleMainClass {
    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(5);
        Scanner scanner = new Scanner(System.in);
        char key = ' '; // 用户接收
        boolean loop = true;
        while (loop){
            System.out.println("s:显示队列");
            System.out.println("a:加入队列");
            System.out.println("l:队列中有效元素");
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
                case 'l':
                    try {
                        System.out.println(queue.getSize());
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
