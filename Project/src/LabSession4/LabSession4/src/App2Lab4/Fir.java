package App2Lab4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fir extends Thread{
    Lock l1, l2;

    int activitymin1, activitymin2, activitymax1, activitymax2, sleep;
    Fir(Lock l1,Lock l2, int activitymin1,int activitymin2,int activitymax1,int activitymax2, int sleep)
    {
        this.l1 = l1;
        this.l2 = l2;
        this.activitymin1 = activitymin1;
        this.activitymin2 = activitymin2;
        this.activitymax1 = activitymax1;
        this.activitymax2 = activitymax2;
        this.sleep = sleep;
    }
    public void run()
    {
        System.out.println(this.getName() + " State 1");
        int k =(int) Math.round(Math.random() * (activitymax1-activitymin1) + activitymax1);
        for (int i = 0; i<k*100000; i++)
        {
            i++;
            i--;
        }
        if (l1.tryLock())
        {
            try{
                System.out.println(this.getName() + " State 2");
                int k1 =(int) Math.round(Math.random() * (activitymax1-activitymin1) + activitymax1);
                for (int i = 0; i<k1*100000; i++)
                {
                    i++;
                    i--;
                }
                if (l2.tryLock()) {
                    try {
                        System.out.println(this.getName() + " State 3");
                        try {
                            Thread.sleep(sleep * 500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } finally {
                        l2.unlock();

                    }
                }
            }finally {
                l1.unlock();

            }
        }
        System.out.println(this.getName() + " State 4");
    }
}