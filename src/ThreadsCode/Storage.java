package ThreadsCode;

import java.beans.IntrospectionException;
import java.util.LinkedList;

public class Storage
{

    private final int MAX_SIZE = 100;
    private final LinkedList<Produce> list = new LinkedList<>();

    public void produce(int num)
    {
        synchronized(list)
        {
            while (list.size() + num > MAX_SIZE)
            {
                System.out.println("仓库空间不足，无法再生产" + num + "个商品");
                try
                {
                    list.wait();
                }
                catch (InterruptedException e){}
            }

            for (int i = 0; i < num; i += 1)
                list.add(new Produce());
            System.out.println("成功生产" + num + "件商品, 当前仓库中有" + list.size() + "件商品");
            list.notify();
        }
    }

    public void consume(int num)
    {
        synchronized (list)
        {
            while (list.size() < num)
            {
                System.out.println("仓库中不足" + num + "个商品");
                try
                {
                    list.wait();
                }
                catch (InterruptedException e)
                {
                }
            }

            for (int i = 0; i < num; i += 1)
                list.remove();
            System.out.println("成功消费" + num + "件商品, 当前仓库中有" + list.size() + "件商品");
            list.notifyAll();
        }
    }
}
