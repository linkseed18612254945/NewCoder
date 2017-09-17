package toOffer;

public class MyPower
{
    public static double pow(double base, int exp)
    {
        if (Math.abs(base) < 0.000000001)
            return 0;
        if (exp == 0)
            return 1;
        double res = 1;
        while (Math.abs(exp) != 1)
        {
            if (exp % 2 != 0)
                res *= base;
            exp >>= 1;
            base *= base;
        }
        return exp > 0 ? base * res : 1 / (base * res);
    }

    public static void main(String[] args)
    {
        System.out.println(pow(2, 63));
        System.out.println(Math.pow(2, 31));
        StringBuilder sb = new StringBuilder();
        byte x = 1;
        sb.append(x);
    }
}
