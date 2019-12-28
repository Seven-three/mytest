package A05_ArrayStack;

import java.util.Objects;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<String>(4);
        stack.push("a");
        stack.push("b");
        stack.pop();
        stack.push("c");
        stack.push("d");
        stack.show();
    }
}

class ArrayStack<E> {
    private int maxSize;
    private int top = -1;
    private Object[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new Object[maxSize];
    }

    /**
     * 是否满
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     */
    public <E> void push(E e) {
        if (isFull())
            throw new RuntimeException("栈满");
        top++;
        stack[top] = e;
    }

    /**
     * 出栈
     */
    public <E> E pop(){
        if (isEmpty())
            throw new RuntimeException("栈空");
        return (E) stack[top--];
    }

    /**
     * 遍历
     */
    public void show(){
        if (isEmpty())
            throw new RuntimeException("栈空");
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
