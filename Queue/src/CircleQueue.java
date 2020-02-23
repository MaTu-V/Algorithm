public class CircleQueue {
    private int maxSize; // 队列大小
    private int[] arr; // 保存
    private int front; // 队列前一个
    private int rear; // 队列结尾

    /**
     * 初始化
     *
     * @param maxSize
     */
    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;// 初始化队列大小
        arr = new int[maxSize]; // 初始化队列
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 判断队列是否已满
     *
     * @return
     */
    public boolean isFull() {
        return front == (rear + 1) % maxSize;
    }

    /**
     * 添加队列元素
     *
     * @param n
     */
    public void addQueue(int n) {
        if (isFull()) {
            throw new RuntimeException("队列已满!");
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 取出队列首元素
     *
     * @return
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空!");
        }
        int pop = arr[front];
        front = (front + 1) % maxSize;
        return pop;
    }

    /**
     * 遍历队列
     */
    public void printQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空!");
        }
        for (int i = front; i < front + getSize(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 队列有效长度
     */

    public int getSize() {
        return (rear + maxSize - front) % maxSize;
    }
}
