package com.uwu;

public class JoinedRunnable implements Runnable {
    private final int val;

    public JoinedRunnable(int val) {
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
        JoinedRunnable joinedRunnable = new JoinedRunnable(5);
        Thread joinedThread = new Thread(joinedRunnable);
        joinedThread.start();
        // joinedThread.interrupt();
        try {
            joinedThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Gets printed after joinedThread completes.
        System.out.println("The main method!");
    }
}
