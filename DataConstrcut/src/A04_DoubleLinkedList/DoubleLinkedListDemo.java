package A04_DoubleLinkedList;

import java.util.ArrayList;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        Node node1 = new Node(1, "熊大");
        Node node2 = new Node(2, "熊二");
        Node node3 = new Node(3, "张三");
        Node node4 = new Node(4, "李四");
        Node node5 = new Node(5, "王五");
        Node node6 = new Node(2, "六六六");
        DoubleLinkedList list = new DoubleLinkedList();
        list.addByOrder(node3);
        list.addByOrder(node2);
        list.addByOrder(node1);
//        list.del(2);
        list.addByOrder(node4);
//        list.update(node6);
        list.show();
    }
}



class DoubleLinkedList{
    
    private Node head = new Node(0, "");

    /**
     * 遍历
     */
    public void show(){
        if (head.next == null)
            throw new RuntimeException("链表为空");
        Node temp = head.next;
        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 添加
     */
    public void add(Node node){
        if (node == null)
            throw new RuntimeException("节点为空");
        Node temp = head;
        while (true){
            if (temp.next == null){
                temp.next = node;
                node.pre = temp;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 有序添加
     */
    public void addByOrder(Node node){
        if (node == null)
            throw new RuntimeException("节点为空");
        Node temp = head;
        while (true){
            if (temp.next == null){
                if (temp.id < node.id){
                    temp.next = node;
                    node.pre = temp;
                }
                break;
            }
            if (temp.next.id > node.id){
                // 处理添加节点和后一个节点
                node.next = temp.next;
                temp.next.pre = node;
                // 处理添加节点和前一个节点
                temp.next = node;
                node.pre = temp;
                break;
            }
            temp = temp.next;
        }

    }

    /**
     * 修改
     */
    public void update(Node node){
        if (node == null)
            throw new RuntimeException("节点为空");
        Node temp = head.next;
        while (temp != null){
            if (temp.id == node.id){
                temp.name = node.name;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 删除
     */
    public void del(int id){
        Node temp = head.next;
        while (temp != null){
            if (temp.id == id){
                temp.pre.next = temp.next;
                temp.next.pre = temp.pre;
                break;
            }
            temp = temp.next;
        }
    }
}



class Node{
    public int id;
    public String name;
    public Node next;
    public Node pre;

    public Node() {
    }

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
