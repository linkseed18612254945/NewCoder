package CompanyTest;

import java.util.*;

public class Wangyi1
{

    public static int mostCity(Integer[] arr, int n, int l)
    {
        Map<Integer, ArrayList<Integer>> cityCollect = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < n; i += 1)
        {
            if (!cityCollect.containsKey(arr[i]))
            {
                cityCollect.put(arr[i], new ArrayList<Integer>());
            }
            cityCollect.get(arr[i]).add(i + 1);
        }
        int maxDepth = depth(cityCollect, 0) + 1;
        if (l + 1 < maxDepth)
            return l + 1;
        else if (l > 2 * (maxDepth - 1))
            return maxDepth + (l - 2 * (maxDepth - 1));
        else
            return maxDepth;
    }

    private static int depth(Map<Integer, ArrayList<Integer>> cityCollect, int start)
    {
        if (!cityCollect.containsKey(start))
            return 0;
        List<Integer> cities = cityCollect.get(start);
        int max = 0;
        for (int city: cities)
        {
            int d = 1 + depth(cityCollect, city);
            max = d > max ? d: max;
        }
        return max;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        Integer[] arr = new Integer[n - 1];
        for (int i = 0; i < n - 1; i += 1)
        {
            arr[i] = sc.nextInt();
        }
        int res = mostCity(arr, n - 1, l);
        System.out.println(res);
    }
}
