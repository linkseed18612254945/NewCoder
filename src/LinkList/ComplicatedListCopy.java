package LinkList;

class RandomListNode
{
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label)
    {
        this.label = label;
    }
}

public class ComplicatedListCopy
{

    public static RandomListNode clone(RandomListNode head)
    {
        RandomListNode current = head, temp;
        while (current != null)
        {
            temp = current.next;
            current.next = new RandomListNode(current.label);
            current.next.next = temp;
            current = temp;
        }
        RandomListNode cloneList = head.next;
        current = head;
        temp = head.next;
        while (true)
        {
            if (current.random == null)
                temp.random = null;
            else
                temp.random = current.random.next;
            if (temp.next == null)
                break;
            current = temp.next;
            temp = current.next;
        }
        current = head;
        temp = cloneList;
        while (temp.next !=  null)
        {
            current.next = current.next.next;
            temp.next = temp.next.next;
            current = current.next;
            temp = temp.next;
        }
        current.next = null;
        return cloneList;
    }

    public static void main(String[] args)
    {
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next;
        RandomListNode cloneHead = clone(head);
    }
}
