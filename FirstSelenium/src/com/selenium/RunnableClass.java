package com.selenium;

class RunnableTest implements Runnable {

    public static int count = 0;
    public RunnableTest(){ }
        
    public void run() {
        while (RunnableTest.count <= 10) {
            try {
                System.out.println("Expl Thread: " + ( ++RunnableTest.count ));
                Thread.sleep(100);
            } 
            catch (InterruptedException ex) {
                System.out.println("Exception in Thread Class : " + ex.getMessage());
            }
        }
    } 
}
public class RunnableClass {
    public static void main(String args[]){
        System.out.println("Starting Main Thread...");
        RunnableTest thread = new RunnableTest();
        Thread t = new Thread(thread);
        t.start();
        while (RunnableTest.count <= 10) {
            try {
                System.out.println("Main Thread: "+( ++RunnableTest.count ));
                Thread.sleep(100);
            } 
            catch (InterruptedException ex){
                System.out.println("Exception in main thread: " + ex.getMessage());
            }
        }
        System.out.println("End of Main Thread...");
    }
}