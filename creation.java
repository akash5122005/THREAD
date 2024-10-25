class NumberPrinter extends Thread
{
    public void run()
    {
        System.out.println("Thread running...");
        try
        {
            for(int i=1;i<=5;i++)
            {
                System.out.println(i);
                Thread.sleep(500);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println("Thread interrupted");
        }
    }  
}  
public class Main {
    public static void main(String[] args) {
        NumberPrinter thread=new NumberPrinter();
        thread.start();
    }
}
