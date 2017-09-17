package BinarySearch;

class TreeNode
{
    int val;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val)
    {
        this.val = val;
    }

    public static TreeNode buildCompleteByArray(int[] arr)
    {
        if (arr == null || arr.length == 0)
            return null;
        TreeNode root = new TreeNode(arr[0]);
        buildHelper(root, arr, 0);
        return root;
    }

    private static void buildHelper(TreeNode parent,int[] arr, int parentIndex)
    {
        if (parent == null)
            return;
        int leftIndex = (parentIndex + 1) * 2 - 1;
        int rightIndex = (parentIndex + 1) * 2;
        if (leftIndex < arr.length)
        {
            parent.left = new TreeNode(arr[leftIndex]);
            buildHelper(parent.left, arr, leftIndex);
        }
        if (rightIndex < arr.length)
        {
            parent.right = new TreeNode(arr[rightIndex]);
            buildHelper(parent.right, arr, rightIndex);
        }

    }
}

public class CompleteTreeCount
{
    public static int countNode(TreeNode root)
    {
        TreeNode current = root;
        int depth = 0;
        while (current != null)
        {
            current = current.left;
            depth += 1;
        }
        depth -= 1;
        return countHelper(root, depth);
    }

    private static int countHelper(TreeNode node, int depth)
    {
        if (node == null)
            return 0;
        if (depth == 0)
            return 1;
        TreeNode current = node;
        for (int i = 0; i < depth - 1; i += 1)
        {
            if (i == 0)
                current = node.right;
            else
                current = node.left;
        }
        if (current.right != null)
            return (int) Math.pow(2, depth) + countHelper(node.right, depth - 1);
        else if (current.left == null)
            return (int) Math.pow(2, depth - 1) + countHelper(node.left, depth - 1);
        else
            return 1 + (int) Math.pow(2, depth - 1) + (int) Math.pow(2, depth);
    }

    public static void main(String[] args)
    {
        TreeNode root = TreeNode.buildCompleteByArray(new int[]{1, 2, 3, 4 ,5, 6, 7});
        int res = countNode(root);
        System.out.println(res);
    }
}
