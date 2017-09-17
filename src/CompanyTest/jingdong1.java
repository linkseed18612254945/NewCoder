package CompanyTest;

import java.util.Scanner;

public class jingdong1
{

    private static int correctCase(StringBuilder s)
    {
        if (s.length() == 4 && isLegal(s))
            return type(s);
        if (s.length() == 2 && isLegal(s))
            return 1;
        if (s.length() <= 1)
            return 0;
        int deleteLeft = 0;
        for (int i = 0; i < s.length(); i += 1)
            if(s.charAt(i) == '(')
            {
                deleteLeft = i;
                break;
            }
        s.deleteCharAt(deleteLeft);
        int sum = 0;
        for (int i = 0; i < s.length(); i += 1)
        {
            if (s.charAt(i) == ')')
            {
                StringBuilder other  = new StringBuilder(s.substring(0, i) + s.substring(i + 1, s.length()));
                if (isLegal(other))
                {
                    sum += correctCase(other);
                }
            }
        }
        return sum;
    }

    private static int type(StringBuilder s)
    {
        return s.charAt(1) == '(' ? 2 : 1;
    }

    private static boolean isLegal(StringBuilder s)
    {
        if (s.length() == 0)
            return true;
        if (s.length() % 2 != 0)
            return false;
        int leftN = 0, rightN = 0;
        for (int i = 0; i < s.length(); i += 1)
        {
            if (s.charAt(i) == '(')
                leftN += 1;
            else
                rightN += 1;
            if (leftN < rightN)
                return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext())
        {
            sb.append(sc.next());
        }
        int res = correctCase(sb);
        System.out.println(res);
    }
}
