public class test
{

    public static void main(String[] args)
    {
        int count = 0;
        for (int i = 0;i <= 1500; i += 1)
        {
            if (i % 2 != 0 && i % 5 != 0 && i % 7 != 0)
                count += 1;
        }
        System.out.println(count);
    }
}



