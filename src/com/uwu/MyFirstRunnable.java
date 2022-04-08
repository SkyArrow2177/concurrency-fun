package com.uwu;

public class MyFirstRunnable implements Runnable {
    private final int val;

    public MyFirstRunnable(int val) {
        this.val = val;
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("sleep interrupted");
        }
        System.out.println("My first runnable. Its value is " + val);
    }

    public static void main(String args[]) {
        MyFirstRunnable myFirstRunnable = new MyFirstRunnable(5);
        Thread myFirstThread = new Thread(myFirstRunnable);
        myFirstThread.start();
        // myFirstThread.interrupt();
        System.out.println("The main method!");
    }
}
