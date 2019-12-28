package A04_DoubleLinkedList;

public class josephuSingleLinkedListDemo
{
    public static void main(String[] args)
    {
        JosephuLinkedList list = new JosephuLinkedList();
        list.countBoy(5, 10, 59);

    }
}

class JosephuLinkedList
{
    private Boy first = null;

    /**
     * 添加多少个小孩
     */
    public void add(int num)
    {
        if (num < 2)
            throw new RuntimeException("参数有误");
        // 辅助指针
        Boy temp = null;
        for (int i = 1; i <= num; i++)
        {
            Boy boy = new Boy(i);
            if (i == 1)
            {
                first = boy;
                first.setNext(first);
                temp = first;
            } else
            {
                temp.setNext(boy);
                boy.setNext(first);
                temp = boy;
            }
        }
    }

    /**
     * 遍历
     */
    public void show()
    {
        if (first == null)
            throw new RuntimeException("链表为空");
        Boy temp = first;
        while (temp.getNext() != first)
        {
            System.out.println(temp.getNo() + "号小孩");
            temp = temp.getNext();
        }
    }

    /**
     * 问题
     */
    public void countBoy(int startNo, int countNum, int num)
    {
        if (startNo < 1 || startNo > num || countNum < 2)
            throw new RuntimeException("参数有误");
        add(num);
        Boy temp = first;
        while (temp.getNext() != first)
        {
            temp = temp.getNext();
        }
        for (int i = 0; i < startNo - 1; i++)
        {
            first = first.getNext();
            temp = temp.getNext();
        }
        while (temp != first)
        {
            for (int i = 0; i < countNum - 1; i++)
            {
                first = first.getNext();
                temp = temp.getNext();
            }
            System.out.println(first.getNo() + "号小盆友出圈");
            first = first.getNext();
            temp.setNext(first);
        }
        System.out.println(first.getNo()+ "号小朋友赢了!!!!!!!!!!!!");
    }
}

class Boy
{
    private int no;
    private Boy next;

    public Boy()
    {
    }

    public Boy(int no)
    {
        this.no = no;
    }

    public int getNo()
    {
        return no;
    }

    public void setNo(int no)
    {
        this.no = no;
    }

    public Boy getNext()
    {
        return next;
    }

    public void setNext(Boy next)
    {
        this.next = next;
    }
}
