package App4Lab7;

import java.util.concurrent.Semaphore;

public class Fir extends Thread{
    Semaphore s;
    int k, permit, sleep;
    String name;
    Fir(String name, Semaphore s, int sleep, int k , int permit)
    {
        this.name = name;
        this.permit = permit;
        this.sleep = sleep;
        this.k = k;
        this.s = s;
    }
    public void run()
    {
        while(true)
        {
            System.out.println("Thread"+ name + " State 1");
            try{
                this.s.acquire(this.permit);
                System.out.println("Thread"+ name + " took a token from semaphore");
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("Thread"+ name + " State 2");
            for (int i = 0; i<k*100000; i++)
            {
                i++;
                i--;
            }
            System.out.println("Thread"+ name + " release a token from semaphore");
            this.s.release(this.permit);

            System.out.println("Thread"+ name + " State 3");
            try {
                Thread.sleep(sleep*500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread"+ name + " State 4");

        }
    }

}