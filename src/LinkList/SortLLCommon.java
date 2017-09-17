package LinkList;

import java.util.ArrayList;
import java.util.Arrays;

/**
 现有两个升序链表，且链表中均无重复元素。请设计一个高效的算法，打印两个链表的公共值部分。
 给定两个链表的头指针headA和headB，请返回一个vector，元素为两个链表的公共部分。请保证返回数组的升序。两个链表的元素个数均小于等于500。保证一定有公共值
 测试样例：
 {1,2,3,4,5,6,7},{2,4,6,8,10}
 返回：[2.4.6]
 */
public class SortLLCommon
{
    public static int[] findCommon(IntListNode headA, IntListNode headB)
    {
        ArrayList<Integer> common = new ArrayList<>();
        while (headA != null && headB != null)
        {
            if (headA.val == headB.val)
            {
                common.add(headA.val);
                headA = headA.next;
                headB = headB.next;
            }
            else if (headA.val > headB.val)
                headB = headB.next;
            else
                headA = headA.next;
        }
        return common.stream().mapToInt(p -> p).toArray();
    }

    public static void main(String[] args)
    {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] b = new int[]{2, 4, 6, 8, 10};
        IntListNode headA = IntListNode.arrayToIntList(a);
        IntListNode headB = IntListNode.arrayToIntList(b);
        int[] res = findCommon(headA, headB);
        System.out.println(Arrays.toString(res));
    }
}
