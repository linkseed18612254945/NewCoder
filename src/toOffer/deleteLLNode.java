package toOffer;

public class deleteLLNode
{

    public static LLNode deleteN(LLNode head, LLNode toBeDel)
    {
        if (head == null || toBeDel  == null)
            return null;
        if (toBeDel == head)
            return head.next;
        LLNode move = head;
        while (move != null && move.next != toBeDel)
        {
            move = move.next;
        }
        if (move == null)
            return head;
        move.next = toBeDel.next;
        return head;
    }

    public static LLNode delete1(LLNode head, LLNode toBeDel)
    {
        if (head == null || toBeDel == null || toBeDel.next == null)
            return deleteN(head, toBeDel);
        toBeDel.key = toBeDel.next.key;
        toBeDel.next = toBeDel.next.next;
        return head;
    }
}
