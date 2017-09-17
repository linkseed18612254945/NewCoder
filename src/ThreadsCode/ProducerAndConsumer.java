package ThreadsCode;



public class ProducerAndConsumer
{
    public static void main(String[] args)
    {
        Storage mainStorage = new Storage();
        Thread produceThread1 = new Thread(new Producer(2, mainStorage));
        Thread produceThread2 = new Thread(new Producer(3, mainStorage));
        Thread produceThread3 = new Thread(new Producer(1, mainStorage));
        Thread produceThread4 = new Thread(new Producer(4, mainStorage));
        Thread consumeThread1 = new Thread(new Consumer(2, mainStorage));
        Thread consumeThread2 = new Thread(new Consumer(3, mainStorage));
        Thread consumeThread3 = new Thread(new Consumer(4, mainStorage));

        produceThread1.start();
        consumeThread1.start();
        consumeThread2.start();
        produceThread2.start();
        produceThread3.start();
        produceThread4.start();
        consumeThread3.start();

    }
}
class Produce
{
    int weight = 2;
    int height = 10;
}

class Producer implements Runnable
{
    private int num;
    private Storage storage;

    public Producer(int num, Storage storage)
    {
        this.num = num;
        this.storage = storage;
    }

    public void produce(int num)
    {
        storage.produce(num);
    }


    public void setNum(int num)
    {
        this.num = num;
    }

    public int getNum()
    {
        return num;
    }

    @Override
    public void run()
    {
        while (true)
            produce(num);
    }
}

class Consumer implements Runnable
{
    private int num = 5;
    private Storage storage;

    public Consumer(int num, Storage storage)
    {
        this.num = num;
        this.storage = storage;
    }

    public void consume(int num)
    {
        storage.consume(num);
    }

    public void setNum(int num)
    {
        this.num = num;
    }

    public int getNum()
    {
        return num;
    }

    @Override
    public void run()
    {
        while (true)
            consume(num);
    }
}
