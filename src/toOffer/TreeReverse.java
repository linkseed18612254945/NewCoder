package toOffer;

public class TreeReverse
{
    public static TreeNode reverse(TreeNode node)
    {
        if (node == null)
            return null;
        TreeNode temp = node.left;
        node.left = reverse(node.right);
        node.right = reverse(temp);
        return node;
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        TreeNode r = reverse(root);
    }
}
