package LinkList;

public class CheckIntersect
{
    public boolean check(IntListNode headA, IntListNode headB)
    {
        if (headA == null || headB == null)
            return false;
        while (headA.next != null || headB.next != null)
        {
            if (headA.next != null)
                headA = headA.next;
            if (headB.next != null)
                headB = headB.next;
        }
        return headA == headB;
    }
}
