//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

class MonitorLockExample {

    public synchronized void task1() {
        try {
            System.out.println("Inside task1");
            Thread.sleep(1000);
        } catch (Exception ex) {
            /// handle exception
        }
    }

    public void task2() {

        System.out.println("Inside task2");
        synchronized (this) {
            System.out.println("Inside task2, synchronized");
        }
    }

    public void task3() {
        try {
            System.out.println("Inside task3");
        } catch (Exception ex) {
            /// handle exception
        }
    }
}


//What is a Monitor Lock?
//1. Every object in Java has an intrinsic lock (monitor lock) associated with it.
//2. This lock ensures exclusive access to a critical section of code or a resource by only allowing one
//thread to execute the synchronized code at a time.

public class Main {
    public static void main(String[] args) {
        MonitorLockExample obj = new MonitorLockExample();
        Thread t1 = new Thread(() -> {
            obj.task1();
        });
//        Thread t2 = new Thread(() -> {
//            obj.task2();
//        });
//        Thread t3 = new Thread(() -> {
//            obj.task3();
//        });
//
       t1.start();
//        t2.start();
//        t3.start();


        MonitorLockExample obj1 = new MonitorLockExample();
        Thread t4 = new Thread(() -> {
            obj1.task1();
        });
//        Thread t5 = new Thread(() -> {
//            obj1.task2();
//        });
//        Thread t6 = new Thread(() -> {
//            obj1.task3();
//        });

        t4.start();
//        t5.start();
//        t6.start();
    }
}