package CompanyTest;

        import java.util.HashMap;
        import java.util.Map;
        import java.util.Scanner;

public class Dididi1
{
    public static int findXor(int[] arr, int n)
    {
        int m = 0;
        int start = 0;
        for(int i=0; i < n; i++)
        {
            if(arr[i] == 0)
            {
                m += 1;
                start = i + 1;
                continue;
            }

            for(int j = start;j < i;j += 1)
            {
                int flag=0;
                for(int k = j; k <= i; k += 1)
                    flag ^= arr[k];
                if(flag == 0){
                    m ++;
                    start=i + 1;
                    continue;
                }
            }
        }
        return m;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i < n; i += 1)
        {
            arr[i] = sc.nextInt();
        }
        int res = findXor(arr, n);
        System.out.println(res);
    }
}





