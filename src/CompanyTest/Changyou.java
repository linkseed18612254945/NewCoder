package CompanyTest;

import java.util.HashMap;
import java.util.Scanner;

public class Changyou
{
    public static char firstRepeat(String str)
    {
        char[] chars = str.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c: chars)
        {
            if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122))
            {
                if (!hashMap.containsKey(c))
                    hashMap.put(c, 1);
                else
                {
                    return c;
                }
            }
        }
        return ' ';
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char res = firstRepeat(str);
        System.out.println(res);
    }
}
