package toOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RebuildTheTree
{

    public static TreeNode rebuild(int[] preOrder, int[] inOrder, int prelo, int prehi, int inlo, int inhi)
    {
        if (preOrder == null || preOrder.length == 0 || preOrder.length != inOrder.length)
            return null;
        if (prelo > prehi || inlo > inhi)
            return null;
//        if (prelo == prehi || inlo == inhi)
//            return new TreeNode(preOrder[prelo]);
        TreeNode root = new TreeNode(preOrder[prelo]);
        int rootPos = -1;
        for (int i = inlo;i <= inhi; i += 1)
            if (inOrder[i] == preOrder[prelo])
            {
                rootPos = i;
                break;
            }
        if (rootPos == -1)
            throw new IllegalArgumentException();
        int leftNum = rootPos - inlo;
        root.left = rebuild(preOrder, inOrder, prelo + 1, prelo + leftNum, inlo, rootPos - 1);
        root.right = rebuild(preOrder, inOrder, prelo + leftNum + 1, prehi, rootPos + 1, inhi);
        return root;
    }

    public static void main(String[] args)
    {
        int[] preOrder = new int[]{1, 2 ,4, 7, 3, 5, 6, 8};
        int[] inOrder = new int[]{4, 7 ,2, 1, 5, 3, 8, 6};
        int n = inOrder.length;
        TreeNode root = rebuild(preOrder, inOrder,0, n - 1, 0, n - 1);
    }
}
