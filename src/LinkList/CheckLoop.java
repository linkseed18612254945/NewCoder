package LinkList;


import java.util.HashSet;

/**
 * 如何判断一个单链表是否有环？有环的话返回进入环的第一个节点的值，无环的话返回-1。如果链表的长度为N，请做到时间复杂度O(N)，额外空间复杂度O(1)。
 */
public class CheckLoop
{

    public static int checkLoopBySet(IntListNode head)
    {
        HashSet<IntListNode> nodesMap = new HashSet<>();
        while (head != null)
        {
            if (nodesMap.contains(head))
                return head.val;
            nodesMap.add(head);
            head = head.next;
        }
        return -1;
    }

    public static int checkLoop(IntListNode head)
    {
        if (head == null)
            return -1;
        IntListNode quick = head;
        IntListNode slow = head;
        while (quick != null && quick.next != null)
        {
            quick = quick.next.next;
            slow = slow.next;
            if (slow == quick)
                break;
        }
        if (quick == null || quick.next == null)
            return -1;
        quick = head;
        while (quick != slow)
        {
            quick = quick.next;
            slow = slow.next;
        }
        return quick.val;
    }

    public static void main(String[] args)
    {
        IntListNode head1 = IntListNode.arrayToIntList(new int[]{1, 2, 3, 4, 5, 6,});
        IntListNode head2 = IntListNode.arrayToIntList(new int[]{1, 2, 3, 4, 5, 6,});
        head2.next.next.next.next.next.next = head2.next.next.next;
        int res = checkLoop(head2);
        System.out.println(res);
    }
}
