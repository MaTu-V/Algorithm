/**
 * 数组方式模拟栈
 */
public class ArrayStack {
    private int[] arr;
    private int maxSize;
    private int pop;

    /**
     * 栈初始化
     *
     * @param maxSize
     */
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        pop = -1;
    }

    /**
     * 判断栈是否满
     *
     * @return
     */
    public boolean isFull() {
        return pop == maxSize - 1;
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return pop == -1;
    }

    /**
     * 入栈
     *
     * @param val
     */
    public void push(int val) {
        if (isFull()) {
            System.out.println("栈满!");
            return;
        }
        arr[++pop] = val;
    }

    /**
     * 出栈
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空!");
        }
        return arr[pop--];
    }

    /**
     * 打印
     */
    public void printArrayStack() {
        if (isEmpty()) {
            System.out.println("栈空!");
            return;
        }
        for (int i = pop; i >= 0; i--) {
            System.out.printf("%d\n", arr[i]);
        }
    }

    /**
     * 获取栈顶 但是不出栈
     */
    public int peek(){
        return arr[pop];
    }

    /**
     * 运算符 优先级确定
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 判断是不是运算符
     */
    public boolean isOper(char val) {
        return val == '*' || val == '/' || val == '+' || val == '-';
    }

    /**
     * 运算规则处理
     * @param num1
     * @param num2
     * @param oper
     * @return
     */
    public int cal(int num1,int num2,int oper){
        int res =0;
        switch (oper){
            case '*':
                res=num1*num2;break;
            case '/':
                res=num2/num1;break;
            case '+':
                res=num1+num2;break;
            case '-':
                res=num2-num1;break;
                default:
                    break;
        }
        return res;
    }
}
