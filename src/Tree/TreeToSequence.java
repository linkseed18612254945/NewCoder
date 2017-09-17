package Tree;

import java.util.ArrayList;
import java.util.List;

public class TreeToSequence
{
    public static int[] preOrder(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        preOrderHelper(res, root);
        return res.stream().mapToInt((t) ->(t)).toArray();
    }

    private static void preOrderHelper(List<Integer> l, TreeNode node)
    {
        if (node == null)
            return;
        l.add(node.val);
        preOrderHelper(l, node.left);
        preOrderHelper(l, node.right);
    }

    public static int[] inOrder(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        inOrderHelper(res, root);
        return res.stream().mapToInt((t) -> (t)).toArray();
    }

    private static void inOrderHelper(List<Integer> l, TreeNode node)
    {
        if (l == null)
            return;
        inOrderHelper(l, node.left);
        l.add(node.val);
        inOrderHelper(l, node.right);
    }

    public static int[] postOrder(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        postOrderHelper(res, root);
        return res.stream().mapToInt((t) -> (t)).toArray();
    }

    private static void postOrderHelper(List<Integer> l, TreeNode node)
    {
        if (l == null)
            return;
        postOrderHelper(l, node.left);
        postOrderHelper(l, node.right);
        l.add(node.val);
    }

    public int[][] convert(TreeNode root)
    {
        int[][] res = new int[3][];
        res[0] = preOrder(root);
        res[1] = inOrder(root);
        res[2] = postOrder(root);
        return res;
    }
}
