package toOffer;

public class PrintN
{
    public static void printN(int n)
    {
        if (n <= 0)
            return;
        byte[] arr = new byte[n];
        int k = n - 1;
        while (true)
        {
            StringBuilder sb = new StringBuilder();
            for (int i = k; i <= n - 1; i += 1)
            {
                sb.append(arr[i]);
            }
            sb.append(" ");
            System.out.print(sb);
            int j = n - 1;
            while (arr[j] == 9)
            {
                if (j == 0)
                    return;
                arr[j] = 0;
                j -= 1;
            }
            arr[j] += 1;
            k = Math.min(k, j);
        }
    }

    public static void main(String[] args)
    {
    }
}
