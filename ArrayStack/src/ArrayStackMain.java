import java.util.Scanner;

public class ArrayStackMain {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        Scanner scanner = new Scanner(System.in);
        char key = ' '; // 用户接收
        boolean loop = true;
        while (loop){
            System.out.println("a:显示栈");
            System.out.println("b:入栈");
            System.out.println("c:出栈");
            key = scanner.next().charAt(0);
            switch (key){
                case 'a':
                    stack.printArrayStack();
                    break;
                case 'b':
                    stack.push(scanner.nextInt());
                    break;
                case 'c':
                    System.out.println(stack.pop());
                    break;
                default:
                    break;
            }
        }
    }
}
