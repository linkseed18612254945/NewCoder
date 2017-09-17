package toOffer;

public class findLastK
{

    public static LLNode find(LLNode head, int k)
    {
        if (k < 1)
            return null;
        LLNode quickNode = head, slowNode = head;
        for (int i = 0;i < k - 1; i += 1)
        {
            if (quickNode == null)
                return null;
            quickNode = quickNode.next;
        }
        while (quickNode != null)
        {
            slowNode = slowNode.next;
            quickNode = quickNode.next;
        }
        return slowNode;
    }

    public static LLNode findMid(LLNode head)
    {
        if (head == null)
            return null;
        LLNode quick = head, slow = head;
        while (quick != null)
        {
            quick = quick.next == null ? null : quick.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
