package A02_Queue;

public class TestQueue {

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue(3);
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        System.out.println(myQueue.get());
        myQueue.headData();
    }
}

class MyQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;


    public MyQueue(Integer maxSize) {
        this.maxSize = maxSize;
        front = -1;
        rear = -1;
        arr = new int[maxSize];
    }


    // 判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }


    // 判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }


    // 添加数据
    public void add(int n) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        rear++;
        arr[rear] = n;
    }


    // 获取数据
    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    // 查看队列所有数据
    public void show() {
        if (isEmpty())
            throw new RuntimeException("队列为空");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("队列数据: " + arr[i]);
        }
    }

    // 显示头数据
    public void headData() {
        if (isEmpty())
            throw new RuntimeException("队列为空");
        System.out.println(arr[front + 1]);
    }


}
