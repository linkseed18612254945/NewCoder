package toOffer;

public class MergeTwoLL
{

    public static LLNode merge(LLNode x, LLNode y)
    {
        if (x == null)
            return y;
        if (y == null)
            return x;
        LLNode sentinel = new LLNode(0);
        LLNode move = sentinel;
        while (x != null && y != null)
        {
            if (x.key <= y.key)
            {
                move.next = x;
                x = x.next;
                move = move.next;
            }
            else
            {
                move.next = y;
                y = y.next;
                move = move.next;
            }
        }
        move.next = x == null ? y : x;
        return sentinel.next;
    }

    public static void main(String[] args)
    {
        LLNode x = LLNode.convert(new int[]{1, 4, 5, 5, 7, 11, 16});
        LLNode y = LLNode.convert(new int[]{0, 2, 3, 5, 6, 8, 10, 12, 19});
        LLNode mergeLL = merge(x, y);

    }
}
