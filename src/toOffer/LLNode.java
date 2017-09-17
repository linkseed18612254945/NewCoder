package toOffer;

public class LLNode
{
    int key;
    LLNode next;

    LLNode(int key)
    {
        this.key = key;
    }

    public static LLNode convert(int[] arr)
    {
        if (arr == null || arr.length == 0)
            return null;
        LLNode sentinel = new LLNode(0);
        LLNode move = sentinel;
        for (int i = 0; i < arr.length; i += 1)
        {
            move.next = new LLNode(arr[i]);
            move = move.next;
        }
        return sentinel.next;
    }
}
