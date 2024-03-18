package LabSession2.Example3;

class JoinTestThread extends Thread {
    private static int sumOfDivisors = 0;
    private Thread t;

    JoinTestThread(String n, Thread t) {
        this.setName(n);
        this.t = t;
    }

    public void run() {
        System.out.println("Thread " + getName() + " has entered the run() method");
        try {
            if (t != null) t.join();
            System.out.println("Thread " + getName() + " executing operation.");

            // Determine divisors and calculate sum
            int num;
            if (getName().equals("Thread 1")) {
                num = 50001; // Start checking from 50001
            } else if (getName().equals("Thread 2")) {
                num = 20001; // Start checking from 20001
            } else {
                System.out.println("Invalid thread name.");
                return;
            }

            int divisorSum = 0;
            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    divisorSum += i;
                }
            }

            // Assign sum to static variable in main class
            if (getName().equals("Thread 1")) {
                sumOfDivisors = divisorSum;
            } else if (getName().equals("Thread 2")) {
                sumOfDivisors += divisorSum;
            }

            Thread.sleep(3000);
            System.out.println("Thread " + getName() + " has terminated operation.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getSumOfDivisors() {
        return sumOfDivisors;
    }
}

