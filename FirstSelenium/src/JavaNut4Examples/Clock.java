package JavaNut4Examples;

public class Clock extends Thread {
  java.text.DateFormat f =      // How to format the time for this locale
    java.text.DateFormat.getTimeInstance(java.text.DateFormat.MEDIUM);
  volatile boolean keepRunning = true;

  public Clock() {         // The constructor
    setDaemon(true);       // Daemon thread: interpreter can exit while it runs
    start();               // This thread starts itself
  }

  public void run() {      // The body of the thread
    while(keepRunning) {   // This thread runs until asked to stop
      String time = f.format(new java.util.Date()); // Current time
      System.out.println(time);                     // Print the time
      try { Thread.sleep(1000); }                   // Wait 1000 milliseconds
      catch (InterruptedException e) {}             // Ignore this exception 
    }
  }

  // Ask the thread to stop running
  public void pleaseStop() { keepRunning = false; }
}
