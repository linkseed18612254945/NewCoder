package LinkList;

public class ClearValue
{
    public static IntListNode clear(IntListNode head, int val)
    {
        IntListNode sentinel = new IntListNode(0, head);
        IntListNode current = head, prior = sentinel;
        while (current != null)
        {
            if (current.val == val)
                prior.next = current.next;
            else
                prior = prior.next;
            current = current.next;
        }
        return sentinel.next;
    }

    public static void main(String[] args)
    {
        IntListNode head = IntListNode.arrayToIntList(new int[]{1, 2, 3, 4, 3, 2, 1});
        head = clear(head, 2);
        IntListNode.printList(head);
    }
}
