package toOffer;

public class MatrixFind
{
    public static boolean find(int[][] matrix, int x)
    {
        if (matrix == null)
            return false;
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0)
        {
            if (matrix[i][j] == x)
                return true;
            else if (matrix[i][j] > x)
                j -= 1;
            else
                i += 1;
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(find(matrix, 99));
    }
}
