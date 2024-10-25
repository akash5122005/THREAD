
class NumberPrinter implements Runnable
{
    private final Object lock;
    private static int counter=1;
    public NumberPrinter(Object lock)
    {
        this.lock=lock;
    }
    public void run()
    {
        while(counter<=10)
        {
            synchronized(lock)
            {
                lock.notify();
                if (counter<=10)
                {
                    System.out.println(Thread.currentThread().getName() + ": "+ counter);
                    counter++;
                }
                try
                {
                    lock.wait();
                } 
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        // Your code here
        Object lock=new Object();
        Thread t2=new Thread(new NumberPrinter(lock),"Thread A");
        Thread t1=new Thread(new NumberPrinter(lock),"Thread B");
        t2.start();
        t1.start();
    }
}
