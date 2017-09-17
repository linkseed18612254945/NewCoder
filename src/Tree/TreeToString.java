package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeToString
{

    public static String treeToString(TreeNode node)
    {
        if (node != null)
            return node.val + "!" + treeToString(node.left) + treeToString(node.right);
        else
            return "#!";
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        System.out.println(treeToString(root));
    }
}
