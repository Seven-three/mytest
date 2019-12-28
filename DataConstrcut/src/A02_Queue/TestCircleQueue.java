package A02_Queue;

public class TestCircleQueue {
    public static void main(String[] args) {
        // test
        CircleQueue q = new CircleQueue(4);
        q.add(1);
        q.add(2);
        q.add(3);
        q.show();
        System.out.println("-----------------");
        q.get();
        q.show();
        q.add(4);
        System.out.println("-----------------");
        q.show();
    }
}

class CircleQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;


    public CircleQueue(Integer maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }


    // 判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }


    // 获取数据
    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    // 查看队列所有数据
    public void show() {
        if (isEmpty())
            throw new RuntimeException("队列为空");
        for (int i = front; i < front + getResultNumber(); i++) {
            System.out.print(i % maxSize);
            System.out.println(" 下标:  " + arr[i % maxSize]);
        }
    }

    // 获取有效数据
    private int getResultNumber() {
        return (rear - front + maxSize) % maxSize;
    }

    // 显示头数据
    public void headData() {
        if (isEmpty())
            throw new RuntimeException("队列为空");
        System.out.println(arr[front]);
    }


}
