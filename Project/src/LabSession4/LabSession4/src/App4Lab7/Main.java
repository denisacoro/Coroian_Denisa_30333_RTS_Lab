package App4Lab7;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(2);
        Fir fir1 = new Fir("Thread 1", s, 5, (int) Math.round(Math.random()*3 + 6),1);
        Fir fir2 = new Fir("Thread 2", s, 3, (int) Math.round(Math.random()*4 + 7),1);
        Fir fir3 = new Fir("Thread 3", s, 6, (int) Math.round(Math.random()*5 + 7),1);
        fir1.start();
        fir2.start();
        fir3.start();
    }
}