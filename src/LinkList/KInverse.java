package LinkList;

public class KInverse
{
    public static IntListNode reverse(IntListNode head, int k)
    {
        int[] temp = new int[k];
        IntListNode getP = head, setP = head;
        out: while (setP != null)
        {
            for (int i = 0; i < k; i += 1)
            {
                temp[i] = getP.val;
                getP = getP.next;
                if (getP == null && i != k - 1)
                    break out;
            }
            for (int i = k - 1; i >= 0; i -= 1)
            {
                setP.val = temp[i];
                setP = setP.next;
            }
        }
        return head;
    }


    public static void main(String[] args)
    {
        IntListNode head = IntListNode.arrayToIntList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        head = reverse(head, 3);
        IntListNode.printList(head);
    }
}
