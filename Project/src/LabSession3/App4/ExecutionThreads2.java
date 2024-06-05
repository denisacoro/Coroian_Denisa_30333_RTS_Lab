package App4;

public class ExecutionThreads2 extends Thread {
    int activity_min, activity_max;
    ExecutionThread1 thread1;
    Integer monitor;
    public ExecutionThreads2( Integer monitor, int activity_min, int activity_max, ExecutionThread1 thread1) {
        this.thread1 = thread1;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.monitor = monitor;
    }
    @Override
    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        synchronized (monitor) {
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(this.getName() + " - STATE 2");
        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        System.out.println(this.getName() + " - STATE 3");
        if(thread1 != null) {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}