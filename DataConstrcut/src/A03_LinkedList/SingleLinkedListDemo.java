package A03_LinkedList;

import java.util.Stack;

public class SingleLinkedListDemo
{
    public static void main(String[] args)
    {
        Node node1 = new Node(1, "熊大");
        Node node2 = new Node(2, "熊二");
        Node node3 = new Node(3, "张三");
        Node node4 = new Node(4, "李四");
        Node node5 = new Node(5, "王五");
        Node node6 = new Node(5, "六六六");
        SingleLinkedList list = new SingleLinkedList();
        list.addByOrder(node2);
        list.addByOrder(node4);
        list.addByOrder(node6);

        SingleLinkedList list1 = new SingleLinkedList();
        list1.addByOrder(node5);
        list1.addByOrder(node1);
        list1.addByOrder(node3);

        list.addAll(list1.head);
        list.show();
        System.out.println("================");
        /*list.update(node6);
        list.show();
        System.out.println("-------------");
        list.del(3);
        list.show();
        System.out.println(list.length());*/
//        list.reverse();
//        list.show();
//        list.reversePrint();
    }
}


class SingleLinkedList
{

    // 定义头结点
    public Node head = new Node();


    /**
     * 添加
     */
    public void add(Node newNode)
    {
        // 健壮性
        if (newNode == null)
            throw new RuntimeException("添加结点为空");

        Node temp = head;
        while (true)
        {
            if (temp.next == null)
            {
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 按顺序添加
     */
    public void addByOrder(Node newNode)
    {
        // 健壮性
        if (newNode == null)
            throw new RuntimeException("添加结点为空");
        // 辅助结点
        Node temp = head;
        // 循环
        while (true)
        {
            if (temp.next == null)
            {
                temp.next = newNode;
                break;
            }
            if (temp.next.no > newNode.no)
            {
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            if (newNode.no == temp.next.no)
                throw new RuntimeException("添加的结点已存在");
            temp = temp.next;
        }
    }

    /**
     * 显示所有
     */
    public void show()
    {
        if (head.next == null)
            throw new RuntimeException("链表为空");

        Node temp = head.next;
        while (temp != null)
        {
            System.out.println(temp);
            temp = temp.next;
        }

    }


    /**
     * 修改
     */
    public void update(Node newNode)
    {
        if (newNode == null)
            throw new RuntimeException("添加结点为空");
        Node temp = head.next;
        while (temp != null)
        {
            if (temp.no == newNode.no)
            {
                temp.name = newNode.name;
                break;
            }
            temp = temp.next;
        }
    }


    /**
     * 删除
     */
    public void del(int no)
    {
        Node temp = head;
        while (true)
        {
            if (temp.next == null)
            {
                break;
            }
            if (temp.next.no == no)
            {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 获取长度
     *
     * @return
     */
    public int length()
    {
        Node temp = head.next;
        int count = 0;
        while (temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }

    /**
     * 获取倒数第K个结点
     */
    public Node getLast(int num)
    {
        if (num < 0 || num > length())
            throw new RuntimeException("参数有误");
        Node temp = head.next;
        for (int i = 0; i < length() - num; i++)
        {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 倒序
     */
    public void reverse()
    {
        if (head.next == null || head.next.next == null)
            throw new RuntimeException("链表为空或只有一个节点");
        // 新的头节点
        Node newHead = new Node();
        // 临时指向节点
        Node temp = head.next;
        // 指向下一个节点临时节点
        Node next = null;
        while (temp != null)
        {
            next = temp.next;
            temp.next = newHead.next;
            newHead.next = temp;
            temp = next;
        }
        // 头结点指向新节点
        head.next = newHead.next;
    }


    /**
     * 倒序打印: 递归
     */
    public void reversePrint(Node temp)
    {
        if (temp == null)
            return;
        reversePrint(temp.next);
        System.out.println(temp);
    }

    /**
     * 倒序打印: 栈方法
     */
    public void reversePrint()
    {
        if (head.next == null || head.next.next == null)
            throw new RuntimeException("链表为空或只有一个节点");
        Node temp = head.next;
        Stack<Node> stack = new Stack<>();
        while (temp != null)
        {
            stack.push(temp);
            temp = temp.next;
        }
        while (stack.size() > 0)
        {
            System.out.println(stack.pop());
        }
    }

    /**
     * 合并链表
     */
    public void addAll(Node otherHead)
    {
        /*if (head.next == null || otherHead.next == null)
            throw new RuntimeException("链表为空");*/
        // 原
        Node temp = head;
        // 其他
        Node otherTemp = otherHead.next;
        Node otherNext = null;
        // 循环
        while (otherTemp != null)
        {
            otherNext = otherTemp.next;
            while (true)
            {
                if (temp.next == null)
                {
                    if (temp.no < otherTemp.no)
                    {
                        otherTemp.next = null;
                        temp.next = otherTemp;
                    }
                    break;
                }
                if (temp.next.no > otherTemp.no)
                {
                    otherTemp.next = temp.next;
                    temp.next = otherTemp;
                    break;
                }
                temp = temp.next;
            }
            temp = head;
            otherTemp = otherNext;
        }


    }
}


class Node
{
    public int no;
    public String name;
    public Node next;

    public Node()
    {
    }

    public Node(int no, String name)
    {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString()
    {

        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}