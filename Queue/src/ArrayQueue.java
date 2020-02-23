/**
 * 数组版队列思想
 */
public class ArrayQueue {
    private int maxSize; // 队列大小
    private int[] arr; // 保存
    private int front; // 队列前一个
    private int rear; // 队列结尾

    /**
     * 初始化
     * @param maxSize
     */
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;// 初始化队列大小
        arr =new int[maxSize]; // 初始化队列
        front = -1;
        rear = -1;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return front == rear;
    }

    /**
     * 判断队列是否已满
     * @return
     */
    public boolean isFull(){
        return rear == maxSize-1;
    }

    /**
     * 添加队列元素
     * @param n
     */
    public void addQueue(int n){
        if (isFull()){
            throw new RuntimeException("队列已满!");
        }
        arr[++rear] = n;
    }

    /**
     * 取出队列首元素
     * @return
     */
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空!");
        }
        return arr[++front];
    }

    /**
     * 遍历队列
     */
    public void printQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空!");
        }
        for (int i =0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    /**
     * 获取队列头元素
     * @return
     */
    public int getHeadQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空!");
        }
        return arr[front + 1];
    }
}
