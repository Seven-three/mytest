package A06_LinkedListStack;

public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}

class LinkedListStack {
    private int maxSize;
    private int count = 0;
    private Node head;

    public LinkedListStack(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * 判断是否满
     *
     * @return
     */
    public boolean isFull() {
        return count == maxSize;
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 入栈
     */
    public void push(Integer num) {
        if (isFull()){
            throw new RuntimeException("栈满");
        }
        count++;
        head = new Node(num, head);
    }

    /**
     * 出栈
     */
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        count--;
        int value = head.no;
        head = head.next;
        return value;
    }

}

class Node {
    public int no;
    public Node next;

    public Node(int no) {
        this.no = no;
    }

    public Node(int no, Node next) {
        this.no = no;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", next=" + next +
                '}';
    }

}