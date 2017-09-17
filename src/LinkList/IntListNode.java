package LinkList;

public class IntListNode
{
    int val;
    IntListNode next;

    public static IntListNode arrayToIntList(int[] arr)
    {
        IntListNode head = new IntListNode(arr[0], null);
        IntListNode current = head;
        for (int i = 1; i < arr.length; i += 1)
        {
            current.next = new IntListNode(arr[i], null);
            current = current.next;
        }
        return head;
    }

    public static void printList(IntListNode head)
    {
        while (head != null)
        {
            if (head.next == null)
            {
                System.out.print(head.val);
                break;
            }
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println();
    }

    public IntListNode(int val,IntListNode next)
    {
        this.val = val;
        this.next =next;
    }
}
